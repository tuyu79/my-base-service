package com.turan;

import com.turan.mq.MyInput;
import com.turan.mq.MyOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({
        MyInput.class,
        MyOutput.class
})
@Slf4j
@SpringCloudApplication
public class MyBaseServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MyBaseServiceApplication.class, args);
    }
}
