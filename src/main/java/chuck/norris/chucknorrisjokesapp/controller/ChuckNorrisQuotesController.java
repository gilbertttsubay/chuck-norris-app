package chuck.norris.chucknorrisjokesapp.controller;

import chuck.norris.chucknorrisjokesapp.model.ChuckNorrisQuotesEntity;
import chuck.norris.chucknorrisjokesapp.service.ChuckNorrisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/api/v1/quotes")
public class ChuckNorrisQuotesController {

    private final ChuckNorrisService chuckNorrisService;
    private Random random = new Random();

    public ChuckNorrisQuotesController(ChuckNorrisService chuckNorrisService) {
        this.chuckNorrisService = chuckNorrisService;
    }

    @GetMapping
    public String getQuote(Model model){
        Iterable<ChuckNorrisQuotesEntity> quotesIterable = chuckNorrisService.findAll();
        List<ChuckNorrisQuotesEntity> quotesList = (List) quotesIterable;

        int randomNumber = random.nextInt(5);

        String quotes = "";
        if (randomNumber < quotesList.size()){
            quotes = quotesList.get(randomNumber).getQuotesChuck();

        } else {
            quotes = "There is no quote from chuck norris for you";
        }

        model.addAttribute("quotes", quotes);

        return "quotes/quotes";



    }

    @PostMapping
    @ResponseBody
    public ChuckNorrisQuotesEntity saveChuckNorrisQuote(@RequestBody ChuckNorrisQuotesEntity chuckNorrisQuotesEntity){
        chuckNorrisService.save(chuckNorrisQuotesEntity);

        return chuckNorrisQuotesEntity;
    }
}
