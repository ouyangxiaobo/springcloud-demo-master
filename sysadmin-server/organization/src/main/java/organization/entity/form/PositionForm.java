package organization.entity.form;

import com.springboot.cloud.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import organization.entity.po.Position;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
public class PositionForm extends BaseForm<Position> {

    @NotBlank(message = "职位名称不能为空")
    @ApiModelProperty(value = "职位名称")
    private String name;

    @ApiModelProperty(value = "职位描述")
    private String description;
}
