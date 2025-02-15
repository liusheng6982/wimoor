package com.wimoor.amazon.report.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wimoor.amazon.common.pojo.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigInteger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用于存储欧洲各个国家的库存
 * </p>
 *
 * @author wimoor team
 * @since 2022-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_amz_rpt_inventory_country")
@ApiModel(value="AmzInventoryCountryReport对象", description="用于存储欧洲各个国家的库存")
public class AmzInventoryCountryReport extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "SKU")
    private String sku;

    @ApiModelProperty(value = "FBA仓库标示码")
    private String fnsku;

    @ApiModelProperty(value = "商品标示")
    private String asin;

    @ApiModelProperty(value = "产品新旧类型")
    private String fcondition;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "库存数量")
    private Integer quantity;

    @ApiModelProperty(value = "授权ID")
    private BigInteger authid;


}
