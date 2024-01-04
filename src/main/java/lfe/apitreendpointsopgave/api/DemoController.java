package lfe.apitreendpointsopgave.api;

import lfe.apitreendpointsopgave.dto.NameResponse;
import lfe.apitreendpointsopgave.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    AppService appService;

    public DemoController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping()
    public NameResponse responseFromName(@RequestParam String name){
        NameResponse response = appService.collectedFromApis(name);
        return response;
    }
}
