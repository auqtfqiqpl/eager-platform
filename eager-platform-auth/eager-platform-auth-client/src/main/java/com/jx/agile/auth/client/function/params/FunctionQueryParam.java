package com.jx.agile.auth.client.function.params;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.jx.agile.auth.client.function.model.entity.Function;
import java.util.Set;

/**
* <p>
* 功能表
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-11
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FunctionQueryParam extends  Function {

    private Set<Boolean> isEnabledList;

    private LocalDateTime startCreatedTime;

    private LocalDateTime endCreatedTime;

    private LocalDateTime startUpdatedTime;

    private LocalDateTime endUpdatedTime;

}