package gr.hua.fitTrack.web.rest;

import gr.hua.fitTrack.core.service.model.CreateTrainerRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainerProfileCreationController {

    @GetMapping("/trainerProfileCreation")
    public String showTrainerForm(
        @RequestParam("personId") Long personId,
                Model model) {
        final CreateTrainerRequest createTrainerRequest = new CreateTrainerRequest(personId,"","","",null,null);
        model.addAttribute("createTrainerRequest",  createTrainerRequest);

        return "trainerProfileCreation";
    }


}
