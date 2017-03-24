package query.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import query.service.data.DataModel;
import query.service.service.TemplateService;

import java.text.ParseException;

@RestController
public class TemplateController {

    private static
    final Logger log = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;


    /**
     * you should input in browser like this:
     * http://localhost:8080/data/aj05s3uw24804210
     *
     * @param invoiceid
     * @return
     * @throws ParseException
     * @throws NumberFormatException
     */
    @RequestMapping(
            value = "/data/{invoiceid}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getData(@PathVariable(value = "invoiceid") String invoiceid) throws NumberFormatException, ParseException {

        if (invoiceid == null || "".equals(invoiceid)) {
            return ResponseEntity.badRequest().body("{ \"message\": \"Missing invoiceid value\"}");
        }

        DataModel dataRes = templateService.getDataByInvoiceId(invoiceid);

        return ResponseEntity.ok(dataRes);
    }
}