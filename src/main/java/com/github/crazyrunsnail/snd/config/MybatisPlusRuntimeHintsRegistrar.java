package com.github.crazyrunsnail.snd.config;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.baomidou.mybatisplus.core.MybatisParameterHandler;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;
import com.baomidou.mybatisplus.core.conditions.interfaces.Func;
import com.baomidou.mybatisplus.core.conditions.interfaces.Join;
import com.baomidou.mybatisplus.core.conditions.interfaces.Nested;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.handlers.CompositeEnumTypeHandler;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.override.MybatisMapperProxy;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.AbstractChainWrapper;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.GsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.SqlSession;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.util.Collections;

@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(MybatisPlusRuntimeHintsRegistrar.class)
public class MybatisPlusRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.proxies()
                .registerJdkProxy(Func.class)
                .registerJdkProxy(Join.class)
                .registerJdkProxy(Query.class)
                .registerJdkProxy(IPage.class)
                .registerJdkProxy(Nested.class)
                .registerJdkProxy(Compare.class)
                .registerJdkProxy(Executor.class)
                .registerJdkProxy(IService.class)
                .registerJdkProxy(SqlSession.class)
                .registerJdkProxy(StatementHandler.class)
        ;

        hints.reflection()
                .registerType(Wrapper.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS))
                .registerType(Wrappers.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS))
                .registerType(MybatisXMLLanguageDriver.class, builder -> builder.withMethod("<init>", Collections.emptyList(), ExecutableMode.INVOKE))
                .registerType(QueryWrapper.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS))
                .registerType(AbstractWrapper.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS))
                .registerType(AbstractChainWrapper.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS))
                .registerType(BoundSql.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS, MemberCategory.DECLARED_FIELDS))
                .registerType(MybatisXMLLanguageDriver.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(MybatisSqlSessionFactoryBean.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(LambdaQueryWrapper.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(LambdaUpdateWrapper.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(UpdateWrapper.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(QueryWrapper.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(QueryWrapper.class, builder -> builder.withMembers(MemberCategory.values()))
                .registerType(IEnum.class, MemberCategory.INVOKE_PUBLIC_METHODS)
                .registerType(CompositeEnumTypeHandler.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(FastjsonTypeHandler.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(GsonTypeHandler.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(JacksonTypeHandler.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(MybatisEnumTypeHandler.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(MybatisParameterHandler.class, MemberCategory.DECLARED_FIELDS)
                .registerType(SFunction.class)
                .registerType(MybatisPlusInterceptor.class)
                .registerType(Page.class, builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS))
                .registerType(PageDTO.class, builder -> builder.withMembers(MemberCategory.values()))
        ;

        hints.serialization().registerType(SFunction.class);

    }

}

