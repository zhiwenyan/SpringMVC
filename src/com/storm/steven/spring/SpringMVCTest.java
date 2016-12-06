package com.storm.steven.spring;


import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.storm.steven.entities.Person;
import com.storm.steven.entities.User;


@SessionAttributes(value={"user"},types={String.class})
@RequestMapping("/springmvc")
@Controller  //C层
public class SpringMVCTest {	
	public static final String SUCCESS="success";
	/**
	 * 类定义处：提供初步的请求映射信息。相对于 WEB 应用的根目录
                  方法处：提供进一步的细分映射信息。相对于类定义处的 URL。若
                  类定义处未标注 @RequestMapping，则方法处标记的 URL 相对于
       WEB 应用的根目录
	 * @return
	 */
	@RequestMapping("testRequestMapping")
	public String testRequestMapping()  {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	/** 常用
	 * (value="/testMethod" 请求的URL
	 * method=RequestMethod.POST 请求的方法
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/testParamsAndHeaders", params={"username","age!=10"},headers={"Accept-Language=zh-CN,zh;q=0.8"})
	public String testParamsAndHeaders(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	/**
	 * 使用 @RequestMapping
      Ant 风格资源地址支持 3 种匹配符：
      – ?：匹配文件名中的一个字符
       – *：匹配文件名中的任意字符
     – **：** 匹配多层路径  
	 * @return
	 */
	@RequestMapping("testAnt/*/abc")
	public String testAnt() {
		System.out.println("testAnt");
		return SUCCESS;
	}
	/**
	 * @PathVariable 映射 URL 绑定的占位 带占位符的 URL 是 Spring3.0 新增的功能，该功能在SpringMVC 向 REST 目标挺进发展过程中具有里程碑的意义
                   通过 @PathVariable 可以将 URL 中占位符参数绑定到制器处理方法的入参中：URL 中的 {xxx} 占位符可以通@PathVariable("xxx") 绑定到操作方法的入参中。
	 * @param id
	 * @return
	 */
	@RequestMapping("testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable:"+id);
		return SUCCESS;
	}


	/**
	 * REST风格
	 * 示例：
– /order/1 HTTP GET ：得到 id = 1 的 order   
– /order/1 HTTP DELETE：删除 id = 1的 order   
– /order/1 HTTP PUT：更新id = 1的 order   
– /order HTTP POST：新增 order

HiddenHttpMethodFilter：浏览器 form 表单只支持 GE
与 POST 请求，而DELETE、PUT 等 method 并不支
持，Spring3.0 添加了一个过滤器，可以将这些请求转换
为标准的 http 方法，使得支持 GET、POST、PUT 与DELETE 请求。
如何发送PUT和DELETE请求？
1.配置 HiddenHttpMethodFilter
2.需要发送POST请求
3。需要在发送POST请求时携带一个name="_method"的隐藏域  值为 DELET或者PUT
	 * @param id
	 * @return
	 */

	//GET
	@RequestMapping(value="testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("testRest:"+id);
		return SUCCESS;
	}

	//POST
	@RequestMapping(value="testRest",method=RequestMethod.POST)
	public String testRest() {
		System.out.println("testPOST");
		return SUCCESS;
	}

	//DELETE
	@RequestMapping(value="testDelete/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id") Integer id) {
		System.out.println("testDelete:"+id);
		return SUCCESS;
	}

	//Put
	@RequestMapping(value="testPut/{id}",method=RequestMethod.PUT)
	public String testPut(@PathVariable("id") Integer id) {
		System.out.println("testPut:"+id);
		return SUCCESS;
	}

	/**
	 * @RequestParam 映射请求参数
	 * value 请求 的参数的名
	 * required 该参数是否必须  默认为true
	 * defaultValue 请求参数的默认值
	 * @param username
	 * @param age
	 * @return
	 */
	@RequestMapping(value="testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String username,
			@RequestParam(value="age",required=false,defaultValue="0") int age) {
		System.out.println("testRequestParam:"+username+","+age);
		return SUCCESS;
	}

	/**
	 * @RequestParam 映射请求头
	 * @param str
	 * @return
	 */

	@RequestMapping(value="testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String str) {
		System.out.println("testRequestHeader:"+str);
		return SUCCESS;
	}	
	/**
	 * @CookieValue 映射ookieValue
	 * @param str
	 * @return
	 */
	@RequestMapping(value="testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID") String str) {
		System.out.println("testCookieValue:"+str);
		return SUCCESS;
	}
	//五、自动装箱
	/**
	 * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹
        配，自动为该对象填充属性值。支持级联属性。
       如：dept.deptId、dept.address.tel 等
	 * @param user
	 * @return
	 */
	@RequestMapping("testpojo")
	public String testpojo(User user) {
		System.out.println("testpojo"+user.toString());
		return SUCCESS;
	}

	//使用 Servlet API 作为入参
	/**
	 * HttpServletRequest
• 	HttpServletResponse
• 	HttpSession
• 	java.security.Principal
•	Locale
• 	InputStream
• 	OutputStream
• 	Reader
• 	Writer
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="testServletApi")
	public String testServletApi(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("testServletApi:"+request+","+response);
		return SUCCESS;
	}

	/**
	 * 控制器处理方法的返回值如果为 ModelAndView, 则其既
                      包含视图信息，也包含模型数据信息
	 * @return
	 */
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView(){
		String viewname=SUCCESS;
		//添加模型数据到ModelAndView中
		ModelAndView modelAndView=new ModelAndView(viewname);
		modelAndView.addObject("time",new Date());
		return modelAndView;
	}
	/**
	 * 如果方法的入参为 Map 或 Model 类型，Spring MVC 会将隐含模型的引用传递给这些入参。在方法体内，开发者可以通过这个入参对象访问到模型中的所有数
                据，也可以向模型中添加新的属性数据
	 * @param map
	 * @return
	 */
	@RequestMapping("testMap")
	public String testMap(Map<String, Object> map){
		map.put("names", Arrays.asList("Tom","Steven","Did"));
		return SUCCESS;
	}


	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String,Object> map){
		Person person=new Person("Steven","123");
		map.put("person", person);
		map.put("school", "Storm");
		return SUCCESS;
	}
	//　在方法定义上使用 @ModelAttribute 注解：Spring MVC 在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法
	//　在方法的入参前使用 @ModelAttribute 注解：可以从隐含对象中获取隐含的模型数据中获取对象，
	// 再将请求参数 –绑定到对象中，再传入入参将方法入参对象添加到模型中 
	@RequestMapping("/testModelAttributes")
	public String testModelAttributes(@ModelAttribute("abc") User user){
		System.out.println("修改:"+user.toString());
		return SUCCESS;
	}
	/**
	 * 在方法定义上使用 @ModelAttribute 注解：Spring MVC
		在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法。
		在方法的入参前使用 @ModelAttribute 注解：
		– 可以从隐含对象中获取隐含的模型数据中获取对象，再将请求参数绑定到对象中，再传入入参– 将方法入参对象添加到模型中
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map){
		System.out.println("@ModelAttribute");
		if(id!=null){
			User user=new User("2","Tom","123456");
			System.out.println("从数据库中获取一个对象："+user);
			map.put("abc", user);
		}
	}
	/**
	 * 运行流程:
	 * 1.执行@ModelAttribute注解修饰的方法：从数据库取出对象，把对象放入到了Map中,键为user
	 * 2.执行SpringMVC从map中取出对象，并把表单的请求的数据赋给User对应的属性
	 * 3.SpringMVC 把上述对象目标方法的参数中
	 * 注意：
	 * @ModelAttribute修饰方法中 ，放入map时的键需要和目标方法入参类型的一个小写字母的的字符串一致；
	 */
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloViews";
	}

	@RequestMapping("/testRedrict")
	public String testRedrict(){
		System.out.println("testRedrict");
		return "redirect:/index.jsp";  //重定向
	}
	@Autowired
	private  ResourceBundleMessageSource  resourceBundleMessageSource;
	@RequestMapping("testi18n")
	public String testi18n(Locale local){
		String value=resourceBundleMessageSource.getMessage("i18n.username", null, local);
		System.out.println(value);
		return "i18n";
	}
	

	//数据验证
	@RequestMapping("emp")
	private String testData(@Valid Employee employee){
		System.out.println("数据验证");
		System.out.println(employee.getEmail());
		return SUCCESS;
	}
}
