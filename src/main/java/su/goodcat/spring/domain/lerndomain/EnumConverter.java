package su.goodcat.spring.domain.lerndomain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EnumConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        return "ENUM_" + attribute.name();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        return Gender.valueOf(dbData.substring(5));
    }
}
