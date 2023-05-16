package com.example.tpProject;

import com.example.tpProject.SoapGen.Add;
import com.example.tpProject.SoapGen.AddResponse;
import com.example.tpProject.SoapGen.Divide;
import com.example.tpProject.SoapGen.DivideResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SoapClient {
    private WebServiceTemplate template;

    @Autowired
    public SoapClient(Jaxb2Marshaller marshaller) {
        this.template = new WebServiceTemplate(marshaller);
    }

    public AddResponse addResult(Add request) {
        System.out.println(request);
        SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Add");
        AddResponse response = (AddResponse) template.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, callback);
        System.out.println(response);
        return response;
    }

    public DivideResponse divideResult(Divide request) {
        System.out.println(request);
        SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Divide");
        DivideResponse response = (DivideResponse) template.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, callback);
        System.out.println(response);
        return response;
    }
}
