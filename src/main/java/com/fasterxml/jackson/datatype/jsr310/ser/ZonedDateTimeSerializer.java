package com.fasterxml.jackson.datatype.jsr310.ser;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends InstantSerializerBase<ZonedDateTime>
{
    private static final long serialVersionUID = 1L;

    public static final ZonedDateTimeSerializer INSTANCE = new ZonedDateTimeSerializer();

    protected ZonedDateTimeSerializer() {
        super(ZonedDateTime.class, dt -> dt.toInstant().toEpochMilli(),
                ZonedDateTime::toEpochSecond, ZonedDateTime::getNano,
                // ISO_ZONED_DATE_TIME is not the ISO format, it is an extension of it
                DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    protected ZonedDateTimeSerializer(ZonedDateTimeSerializer base,
            Boolean useTimestamp, DateTimeFormatter formatter) {
        super(base, useTimestamp, formatter);
    }

    @Override
    protected JSR310FormattedSerializerBase<?> withFormat(Boolean useTimestamp, DateTimeFormatter formatter) {
        return new ZonedDateTimeSerializer(this, useTimestamp, formatter);
    }
}
