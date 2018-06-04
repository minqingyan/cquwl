package com.cactus.cquwl.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;
import com.cactus.cquwl.domain.entity.CarResult;
import com.cactus.cquwl.domain.entity.TestObj;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarAssess;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.StoreGood;
import com.cactus.cquwl.pojo.StoreSource;
import com.cactus.cquwl.service.IAdminUserService;
import com.cactus.cquwl.service.ICarAssessService;
import com.cactus.cquwl.service.ICarSourceOptimizationService;
import com.cactus.cquwl.service.ICarSourceOrderService;
import com.cactus.cquwl.service.ICarSourceService;
import com.cactus.cquwl.service.IGoodSourceService;
import com.cactus.cquwl.service.IStoreGoodService;
import com.cactus.cquwl.service.IStoreSourceService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

@Controller
public class IndexController {
	private static final String stragepic = "assets/img/stragepic/20161214110936.png";
	private static final String stragepic1 = "assets/img/stragepic/201612141112381.png";
	private static final String stragepic2 = "assets/img/stragepic/201612141112382.png";
	private static final String stragepic3 = "assets/img/stragepic/201612141112383.png";
	private static final String stragepic4 = "assets/img/stragepic/201612141112384.png";
	
	private Logger logger =Logger.getLogger(IndexController.class);
	@Autowired
	private IGoodSourceService goodSourceService;
	
	@Autowired
	private IAdminUserService userService;  
	
	@Autowired
	private ICarSourceService carSourceService;
	
	@Autowired
	private IStoreSourceService storeSourceService;
	
	@Autowired
	private ICarSourceOrderService carSourceOrderService;
	
	@Autowired
	private ICarAssessService carAssessService;
	
	@Autowired
	private IStoreGoodService storeGoodService;
	
	@Autowired
	private ICarSourceOptimizationService carSourceOptimizationService;
	
	protected AdminUser getPersistentAdminUser(){
		Subject subject= SecurityUtils.getSubject();
		AdminUser adminUser=userService.selectAdminUserByPhone((String)subject.getPrincipal());
		if(TextUtil.isNullObject(adminUser)){
			logger.error("--------- no login ");
			return null;
		}else{
			logger.error("--------- i am login ");
			 logger.error("--------- userphone ");
			 return adminUser;
		}
	}
	
	@RequestMapping("/home")  
    public ModelAndView index(@RequestParam String userName) { 
		Subject subject= SecurityUtils.getSubject();
		AdminUser user=(AdminUser)subject.getPrincipal();
		ModelAndView mav=new ModelAndView("views/index");
		mav.addObject("userName",user.getUserName());
        System.out.println("登录成功");
        return mav;
    }
	
	//首页/  普通件杂货
	@RequestMapping(value="/ptjzh")
	public String ptjzh(@ModelAttribute BasicGood good,HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
		good.setType(2);
		good.setState(1);
		goodSourceService.saveGoodSource(good,getPersistentAdminUser());
		return "redirect:/backzhzy";
	}
	
	//首页/  大宗散货
	@RequestMapping(value="/dzsh")
	public String dzsh(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model,
					@RequestParam String dzshname,
					@RequestParam String weight,
					@RequestParam String volumn,
					@RequestParam String city_picker_dz_start,
					@RequestParam String city_picker_dz_end,
					@RequestParam String date_picker_dz_start,
					@RequestParam String date_picker_dz_end) throws java.text.ParseException{
		
		BasicGood bg=new BasicGood();
		bg.setDeliveryTime(date_picker_dz_start);
		bg.setUnloadTime(date_picker_dz_end);
		bg.setName(dzshname);
		bg.setState(1);
		bg.setType(1);
		bg.setVolumn(TextUtil.stringToFloat(volumn));
		bg.setWeight(TextUtil.stringToFloat(weight));
		bg.setPublishTime(TimeUtil.getCurrentDate());
		bg.setPlaceArrive(city_picker_dz_end);
		bg.setPlaceStart(city_picker_dz_start);
		goodSourceService.saveGoodSource(bg,getPersistentAdminUser());
		return "redirect:/backzhzy";
	}
	
	// 发布智能结果推送
	// 综合最优
	@RequestMapping(value="/backzhzy")
	public ModelAndView backzhzy(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("views/backzhzy");
		// status=1 是大宗散货 status=2 件杂货   status=3 是仓库货物
		
		mav.addObject("data", carSourceOptimizationService.getCarSourceTable(getPersistentAdminUser()));
		mav.addObject("stragepic", stragepic);
		mav.addObject("stragepic1", stragepic1);
		mav.addObject("stragepic2", stragepic2);
		mav.addObject("stragepic3", stragepic3);
		mav.addObject("stragepic3", stragepic4);
		return mav;
	}
	// 评价最优
	@RequestMapping(value="/backpjzy")
	public String backpjzy(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/backpjzy";
	}
	// 距离最优
	@RequestMapping(value="/backjlzy")
	public String backjlzy(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/backjlzy";
	}
	// 单价最优
	@RequestMapping(value="/backdjzy")
	public String backdjzy(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/backdjzy";
	}
	
	// 发布智能结果推送
	@RequestMapping(value="/addresult")
	public String addresult(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/indexresult";
	}
	
	// 智能预约接口
	@RequestMapping(value="/resultordering")
	@ResponseBody
	public JSONObject resultordering(HttpServletRequest request,HttpServletResponse response){
		String str = request.getParameter("str");
		// // 1货源（仓库）；2货源（车辆）；3车源；4仓库源
		return carSourceOrderService.saveOrderingAndChangeGood(getPersistentAdminUser(), str, 3);
	}
	
	@RequestMapping(value="/getcarmsg")
	public ModelAndView getcarmsg(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		//确定读取信息
		ModelAndView mav = new ModelAndView("views/detailmsg");
		mav.addObject("data", carSourceService.findCarById(id));
		return mav;
	}
	//账号管理
	@RequestMapping(value="/zhmanage")
	public String zhmanage(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/zhmanage";
	}
	
	@RequestMapping(value="/xyrz")
	public String xyrz(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/xyrz";
	}
	
	//我的发布
	// 货源
	@RequestMapping(value="/wdfbgood")
	public String wdfbgood(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdfbgood";
	}
	
	// 车源
	@RequestMapping(value="/wdfbcar")
	public String wdfbcar(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdfbcar";
	}
	
	// 仓库源
	@RequestMapping(value="/wdfbstore")
	public String wdfbstore(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdfbstore";
	}		
	
	//我的订单toAssess
	@RequestMapping(value="/wdddgood")
	public String wdddgood(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdddgood";
	}
	@RequestMapping(value="/wdddcar")
	public String wdddcar(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdddcar";
	}
	@RequestMapping(value="/wdddstore")
	public String wdddstore(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdddstore";
	}
	//我的评价
	// 货源
	@RequestMapping(value="/wdpjgood")
	public String wdpjgood(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdpjgood";
	}
	// 车源
	@RequestMapping(value="/wdpjcar")
	public String wdpjcar(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdpjcar";
	}
	// 仓库源
	@RequestMapping(value="/wdpjstore")
	public String wdpjstore(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/wdpjstore";
	}
	
	//我的评价
	@RequestMapping(value="/helps")
	public String helps(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/helps";
	}
	
	@RequestMapping(value="/assess")
	public String assess(HttpServletRequest request,HttpServletResponse response,Model model){
		return "views/center/assess";
	}
	
	@RequestMapping(value="/getOrderMsg",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject toAssess(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		String orderId = request.getParameter("orderId");
		System.out.println(orderId);
		// 获取订单编号
		JSONObject json = new JSONObject();
		json.put("status", 1);
		json.put("orderMsg", carSourceOrderService.findOrderById(orderId));
		json.put("carMsg", carSourceService.findCarById(id));
		// 获取车辆信息
		return json;
	}
	
	@RequestMapping(value="/publishAssess",method=RequestMethod.POST)  
    public String publishAsses(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model,
						    		@RequestParam String ddsj,
						    		@RequestParam String hshc,
						    		@RequestParam String fwtd,
						    		@RequestParam String sfhl,
						    		@RequestParam String dpnr,@RequestParam String id,@RequestParam String orderId) { 
		
		System.out.println(ddsj+"-"+"dpnr:"+dpnr+" id="+id+" orderId="+orderId);
		// 保存
		CarAssess ca = new CarAssess();
		ca.setArriveScore((int)Float.parseFloat(ddsj));
		ca.setGoodSafe((int)Float.parseFloat(hshc));
		ca.setServiceScore((int)Float.parseFloat(fwtd));
		ca.setPayScore((int)Float.parseFloat(sfhl));
		ca.setWords(dpnr);
		ca.setState(1);
		carAssessService.addCarAssess(id, orderId, ca);
		return "forward:/successAssess";
    }	
		
	@RequestMapping(value="/getVehicleMsg",method=RequestMethod.GET)  
	@ResponseBody
    public JSONObject getDepartment(HttpServletRequest request,HttpServletResponse response) { 
		return carSourceService.selectCarTable(getPersistentAdminUser());
    }	
	
	// 获取车辆评价
	@RequestMapping(value="/getAssessMsg",method=RequestMethod.POST)  
	@ResponseBody
    public JSONObject getAssessMsg(HttpServletRequest request,HttpServletResponse response) { 
		String id = request.getParameter("id");
		System.out.println(id);
		return carAssessService.readCarAssessById(id);
    }
		
		@RequestMapping(value="/getVehicleMsg2",method=RequestMethod.GET)  
		@ResponseBody
	    public JSONObject getDepartment2(HttpServletRequest request,HttpServletResponse response) { 
			List<CarResult> carList=new ArrayList<CarResult>();
			CarResult car=null;
			for(int i=0;i<30;i++){
				car=new CarResult();
				car.setCarMsg("奥迪Q"+i);
				car.setCarNowPlace("重大"+i+"区");
				car.setCarNumber("渝A"+i+"888");
				car.setCarPhone("1322030905"+i);
				car.setCarToPlace("至北京"+i+"区");
				carList.add(car);
			}
			JSONObject json=new JSONObject();
			json.put("total", carList.size());
			json.put("rows", carList);
			return json;
	    }	
		
		// 预定 --- 订单--汽车
		@RequestMapping(value="/ordering",method=RequestMethod.POST)  
		@ResponseBody
		public JSONObject saveOrdering(HttpSession session,
				@RequestParam String id,@RequestParam String flag,
				HttpServletRequest request,HttpServletResponse response) throws ParseException{
			return carSourceOrderService.saveOrdering(getPersistentAdminUser(), id, Integer.parseInt(flag));
		}
		// 汽车货物
		@RequestMapping(value="/orderingCarGood",method=RequestMethod.POST)  
		@ResponseBody
		public JSONObject orderingCarGood(HttpSession session,
				@RequestParam String id,@RequestParam String flag,
				HttpServletRequest request,HttpServletResponse response) throws ParseException{
			return carSourceOrderService.saveOrdering(getPersistentAdminUser(), id, 2);
		}
		// 仓库货物
		@RequestMapping(value="/orderingStoreGood",method=RequestMethod.POST)  
		@ResponseBody
		public JSONObject orderingStoreGood(HttpSession session,
				@RequestParam String id,@RequestParam String flag,
				HttpServletRequest request,HttpServletResponse response) throws ParseException{
			return carSourceOrderService.saveOrdering(getPersistentAdminUser(), id, 1);
		}
		
		@RequestMapping(value="/getVehicleOrderMsg",method=RequestMethod.GET)  
		@ResponseBody
		public JSONObject getVehicleOrderMsg(HttpSession session,
				HttpServletRequest request,HttpServletResponse response){
			return carSourceOrderService.findOrderByUser(getPersistentAdminUser(), 2);
		}
		
		@RequestMapping(value="/getCarGoodsMsg",method=RequestMethod.GET)  
		@ResponseBody
		public JSONObject getCarGoodsMsg(HttpSession session,HttpServletRequest request,HttpServletResponse response){
			return goodSourceService.getGoodsTable(getPersistentAdminUser());
		}
		
		@RequestMapping(value="/getMyCarGoodsMsg",method=RequestMethod.GET)  
		@ResponseBody
		public JSONObject getMyCarGoodsMsg(HttpSession session,HttpServletRequest request,HttpServletResponse response){
			return goodSourceService.getGoodsTable(getPersistentAdminUser());
		}
		
		@RequestMapping(value="/getStoreGoodsMsg",method=RequestMethod.GET)  
		@ResponseBody
		public JSONObject getStoreGoodsMsg(HttpSession session,HttpServletRequest request,HttpServletResponse response){
			return goodSourceService.getStoreGoodsTable(getPersistentAdminUser());
		}
		
		@RequestMapping(value="/getMyStoreGoodsMsg",method=RequestMethod.GET)  
		@ResponseBody
		public JSONObject getMyStoreGoodsMsg(HttpSession session,HttpServletRequest request,HttpServletResponse response){
			return goodSourceService.getMyStoreGoodsTable(getPersistentAdminUser());
		}
		
		@RequestMapping(value="/getStoreMsg",method=RequestMethod.GET)  
		@ResponseBody
		public JSONObject getStoreMsg(HttpSession session,HttpServletRequest request,HttpServletResponse response){
			return storeSourceService.selectStoreSource(1, getPersistentAdminUser());
		}
		
		@RequestMapping(value="/deleteGood",method=RequestMethod.POST)  
		public String deleteGood(HttpSession session,HttpServletRequest request,HttpServletResponse response
				,@RequestParam String flag,@RequestParam String id){
			return goodSourceService.deleteGoodSource(flag, id);
		}
		
		@RequestMapping(value="addCarMsg",method=RequestMethod.POST)
		public String addCarMsg(@ModelAttribute CarSource car,HttpSession session,HttpServletRequest request,HttpServletResponse response){
			carSourceService.addCarMsg(car,getPersistentAdminUser());
			return "forward:/soucecar";
		}
		
		// 添加仓库货源
		@RequestMapping(value="addStoreGoodMsg",method=RequestMethod.POST)
		public String addStoreGoodMsg(@ModelAttribute StoreGood sg,HttpSession session,HttpServletRequest request,HttpServletResponse response){
			storeGoodService.saveStoreGood(sg,getPersistentAdminUser());
			return "views/soucedb";
		}
		
		// 添加仓库源
		@RequestMapping(value="addStoreMsg",method=RequestMethod.POST)
		public String addStoreMsg(@ModelAttribute StoreSource sg,HttpSession session,HttpServletRequest request,HttpServletResponse response){
			storeSourceService.saveStoreSource(sg,getPersistentAdminUser());
			return "views/soucedb";
		}
		
		
		@RequestMapping(value="getMsg",method=RequestMethod.GET)
		@ResponseBody
		public JSONObject getMsg(HttpSession session,HttpServletRequest request,HttpServletResponse response){
			AdminUser user=getPersistentAdminUser();
			JSONObject json=new JSONObject();
			if(!TextUtil.isNullObject(user)){
				json.put("status", 1);
				json.put("userName", user.getUserName());
				json.put("phone", user.getPhone());
				json.put("email", user.getEmail());
				json.put("area", user.getArea());
				json.put("areaDetail", user.getAreaDetail());
			}else
				json.put("status", 2);
			return json;
		}
		
		@RequestMapping(value="saveMsg",method=RequestMethod.POST)
		public String addCarMsg(@ModelAttribute AdminUser user,HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model){
			AdminUser adminUser=getPersistentAdminUser();
			if(!TextUtil.isNullObject(adminUser)){
				user.setAdminUserId(adminUser.getAdminUserId());
				user.setCreateDate(adminUser.getCreateDate());
				user.setPassword(adminUser.getPassword());
				user.setIsDelete(adminUser.getIsDelete());
			}
			userService.saveAdminUser(user);
			return "redirect:/zhmanage";
		}
		
}
