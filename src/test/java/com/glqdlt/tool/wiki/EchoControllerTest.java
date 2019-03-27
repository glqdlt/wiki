package com.glqdlt.tool.wiki;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author glqdlt
 * 2019-03-27
 */
@WebMvcTest(value = EchoController.class)
@RunWith(SpringRunner.class)
@Slf4j
public class EchoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void replyEcho() throws Exception {
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("message","hello");
        params.add("count","2");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting")
                .params(params);

        MvcResult res = mockMvc.perform(requestBuilder)
                .andReturn();

        Assert.assertEquals("replyEcho 에서 제대로 된 응답을 하지 않음","reply ~ hellohello",res.getResponse().getContentAsString());
    }
}