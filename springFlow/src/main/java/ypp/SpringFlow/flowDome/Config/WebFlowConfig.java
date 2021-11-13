package ypp.SpringFlow.flowDome.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

/**
 * spring web flow JavaConfig
 * flow还是通过xml来配置，后期可实现插拔式代码组件执行流程
 */
//@Configuration
//@ComponentScan(basePackages={"ypp.SpringFlow.flowDome"})
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder()
                .setBasePath("/WEB-INF/flows")
                .addFlowLocationPattern("/**/*-flow.xml")
                .build();
    }

    @Bean
    public FlowExecutor flowExecutor(FlowDefinitionRegistry flowRegistry) {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor flowExecutor) {
        FlowHandlerAdapter flowHandlerAdapter =
                new FlowHandlerAdapter();
        flowHandlerAdapter.setFlowExecutor(flowExecutor);
        return flowHandlerAdapter;
    }

    @Bean
    public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry flowRegistry) {
        FlowHandlerMapping flowHandlerMapping =
                new FlowHandlerMapping();
        flowHandlerMapping.setFlowRegistry(flowRegistry);
        flowHandlerMapping.setOrder(0);
        return flowHandlerMapping;
    }
}

