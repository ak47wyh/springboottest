package com.example.demo.t1;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    public void outputResult(){
        System.out.println("name of Bean :"+beanName);
        Resource resource = loader.getResource("classpath:com/example/demo/t1/test.txt");

        try {
            InputStream is = resource.getInputStream();
            System.out.println(IOUtils.toString(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader=resourceLoader;
    }
}
