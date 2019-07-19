package com.shawn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestStream {

    /**
     * 目的：在集合中匹配某一项，比如[aaa,bbb,ccc,eee,fff]匹配中含有e的那一项<br>
     */
    @Test
    public void testSteamFilter() {
        List<String> lists = new ArrayList<>();
        lists.add("abc");
        lists.add("cde");
        List<String> newList = lists.stream().filter(list -> list.equals("cde")).collect(Collectors.toList());
        //FIXME @shawn 增加日志级别 @Slf4j<br>
        System.out.print(newList.get(0));
    }

    /**
     *  FIXME @shawn 写一个加载资源的类，参考如下代码<br>
     * AutoConfigurationSelector<br> 加载资源的代码
     *     protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
     *         List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
     *         Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
     *         return configurations;
     *     }
     */

}
