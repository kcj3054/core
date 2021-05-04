package hello.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
}
