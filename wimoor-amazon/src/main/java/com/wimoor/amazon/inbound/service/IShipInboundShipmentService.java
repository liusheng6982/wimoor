package com.wimoor.amazon.inbound.service;

 
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.wimoor.amazon.inbound.pojo.dto.ShipCartShipmentDTO;
import com.wimoor.amazon.inbound.pojo.dto.ShipInboundShipmenSummaryDTO;
import com.wimoor.amazon.inbound.pojo.entity.ShipInboundBox;
import com.wimoor.amazon.inbound.pojo.entity.ShipInboundCase;
import com.wimoor.amazon.inbound.pojo.entity.ShipInboundShipment;
import com.wimoor.amazon.inbound.pojo.entity.ShipInboundTrans;
import com.wimoor.api.amzon.inbound.pojo.dto.ShipInboundShipmentDTO;
import com.wimoor.api.amzon.inbound.pojo.vo.ShipInboundShipmenSummarytVo;
import com.wimoor.common.user.UserInfo;
 
 

public interface IShipInboundShipmentService extends IService<ShipInboundShipment>{

	IPage<ShipInboundShipmenSummarytVo> findByTraceCondition(ShipInboundShipmenSummaryDTO dto);
	public String createInboundShipment(ShipInboundShipment shipment) ;
	String updateInboundShipment(ShipInboundShipment shipment, String actiontype);
	String saveCartShipment(UserInfo user, ShipCartShipmentDTO dto);
	public String getLabelUrl(String shipmentid,String pagetype,String labelType, String pannum);
	List<ShipInboundShipmenSummarytVo> getShipmentSyncList(Map<String, Object> param);
	Map<String, Object> findToCountry(String destinationFulfillmentCenterId, String region);
	ShipInboundShipmentDTO syncShipment(String groupid, String marketplaceid, String shipmentid, String warehouseid);
	public ShipInboundShipmenSummarytVo getUnSyncShipment(String groupid, String marketplaceid, String shipmentid, String warehouseid);
	public void setExcelBookShipmentLabel(String shopid, SXSSFWorkbook workbook, String shipmentid,List<Map<String,Object>> paralist);
	public void setPDFDocLabel(Document document, List<Map<String,Object>> skulist, PdfWriter writer);
	public void setPDFDocLabel(String shopid, Document document, String shipmentid, PdfWriter writer);
	public void validateShipment(String shipmentid);
	public ShipInboundTrans getSelfTransData(String shipmentid);
	public List<Map<String, Object>> findInboundItemByShipmentId(String shipmentid);
	public Integer findhasAssemblyFormNum(String shipmentid);
	Map<String, String> getPkgPaper(String type);
	List<ShipInboundBox> findShipInboundBoxByShipment(String shipmentid);
	List<ShipInboundCase> findShipInboundCaseByShipment(String shipmentid);
	List<Map<String, Object>> findShipInboundBox(String shipmentid);
	Map<String, Object> getSelfTransDataView(String shipmentid);
	Object getTransChannelInfo(String string);
	List<String> getCarrierInfo(String country, String transtyle);
	void setExcelBoxDetail(UserInfo user, SXSSFWorkbook workbook, String shipmentid);
	void saveSelfTransData(UserInfo user, ShipInboundTrans ship, String operate, List<Map<String, Object>> box,
			String proNumber, Date shipsdate, String carrier);
	List<Map<String, Object>> getSelfTransHis(String companyid, String shipmentid);
	int saveTransData(UserInfo user, String shipmentid, String company, String channel);
	void setExcelBookBySku(SXSSFWorkbook workbook, Map<String, Object> params);
    public Integer refreshShipmentRec(String shipmentid);
	void ignoreShipment(UserInfo user, String shipmentid);
 
}
