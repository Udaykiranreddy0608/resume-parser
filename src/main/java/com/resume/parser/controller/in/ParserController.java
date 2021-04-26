package com.resume.parser.controller.in;

import com.resume.parser.ResponseWrapper;
import com.resume.parser.service.in.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class ParserController {

  @Autowired private ParserService parserService;

  @PostMapping("/upload")
  public ResponseWrapper parseResume(@RequestParam MultipartFile resume) {
    ResponseWrapper responseWrapper = null;
    try {
      responseWrapper = parserService.parseResume(resume);
    } catch (Exception ex) {
      responseWrapper = new ResponseWrapper();
      responseWrapper.setMessage(ex.getMessage());
      responseWrapper.setStatus(500);
      ex.printStackTrace();
    }
    return responseWrapper;
  }

  @ExceptionHandler(MultipartException.class)
  public ResponseWrapper handleMultipartException(Exception ex) {
    ResponseWrapper responseWrapper = new ResponseWrapper();
    responseWrapper.setData("No file uploaded");
    responseWrapper.setMessage("Please upload Resume!!");
    responseWrapper.setStatus(400);
    return responseWrapper;
  }
}
