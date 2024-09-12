package org.example.mvcmeganetproject1.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.mvcmeganetproject1.model.Bid;
import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.service.BidService;
import org.example.mvcmeganetproject1.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;
    private final CityService cityService;

    @GetMapping("/bid")
    public String showBidForm(Model model) {
        model.addAttribute("bid", new Bid());
        return "bid-form";
    }

    @PostMapping("/bid")
    public String submitBid(@Valid @ModelAttribute Bid bid,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {
            return "bid-form";
        }

        String city = bid.getCity();
        Optional<City> optionalCity = cityService.findCityByName(city);

        if (!optionalCity.isPresent()) {
            model.addAttribute("message","Ваш город не обслуживается");
            return "bid-form";
        }

        bidService.saveBid(bid);

        if (!bid.isConnectable()) {
            model.addAttribute("message", "Ваш город или улица не обслуживается. Если будет больше заявок с вашей улицы, с вами свяжутся.");
        } else {
            model.addAttribute("message", "Заявка успешно отправлена. Мы с вами свяжемся.");
        }
        return "bid-form";
        //return "redirect:/index";
    }

    @GetMapping("/bids")
    public String getAllBids(Model model) {
        List<Bid> bids = bidService.findAllBids();  // Получаем все заявки из сервиса
        model.addAttribute("bids", bids);  // Передаём список заявок в модель
        return "bidList";  // Возвращаем название страницы для отображения заявок
    }
}
