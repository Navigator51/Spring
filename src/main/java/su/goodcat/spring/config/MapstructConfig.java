package su.goodcat.spring.config;

import org.mapstruct.*;

@MapperConfig(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        // проверяем поля на null, если null, то не перекладываем
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class MapstructConfig { }
