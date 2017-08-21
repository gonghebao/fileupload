package web;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.AdDao;
import dao.CuisineDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.Variteydao;
import dao.dinnerTableDao;
import entity.Admin;
import entity.Cuisine;
import entity.Detail;
import entity.Order;
import entity.Variety;
import entity.dinnerTable;
import util.ImageUtil;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//鑾峰彇褰撳墠鐨勮闂矾寰�
		String path = req.getServletPath();
//		System.out.println(req.getRequestURI());
//		System.out.println(req.getRequestURL());
		if("/toIndex.do".equals(path)){
			toIndex(req,res);
		}else if("/toBoardList.do".equals(path)){
			toBoardList(req,res);
		}else if("/toCuisineList.do".equals(path)){
			toCuisineList(req,res);
		}else if("/toFoodList.do".equals(path)){
			toFoodList(req,res);
		}else if("/toFrderList.do".equals(path)){
			toFrderList(req,res);
		}else if("/toOrderDetail.do".equals(path)){
			toOrderDetail(req,res);
		}else if("/toSaveFood.do".equals(path)){
			toSaveFood(req,res);
		}else if ("/SaveFood.do".equals(path)) {
			SaveFood(req, res);
		}else if ("/delete.do".equals(path)) {
			delete(req,res);
		}else if ("/toUpdateFood.do".equals(path)) {
			toUpdateFood(req,res);
		}else if ("/UpdateFood.do".equals(path)) {
			UpdateFood(req,res);
		}else if ("/sosuo.do".equals(path)) {
			sousuoFood(req,res);
		}else if("/viewUpdate.do".equals(path)){
			viewUpdate(req,res);
		}else if("/updateCuisine.do".equals(path)){
			update(req,res);
		}else if("/delCuisine.do".equals(path)){
			delCuisine(req,res);
		}else if("/saveCuisine.do".equals(path)){
			saveCuisine(req,res);
		}else if("/toAddCuisine.do".equals(path)){
			toAddCuisine(req,res);
		}else if("/tableName.do".equals(path)){
			tableName(req,res);
		}else if ("/deltable.do".equals(path)) {
			deltable(req, res);
		}else if ("/updateTable.do".equals(path)) {
			updateTable(req, res);
		}else if ("/addTable.do".equals(path)) {
			inserttable(req, res);
		}else if ("/toAddTable.do".equals(path)) {
			toinserttable(req, res);
		}else if ("/tologin.do".equals(path)) {
			toLogin(req, res);
		}  else if ("/login.do".equals(path)) {
			login(req, res);
		} else if ("/createimg.do".equals(path)) {
			createImg(req, res);
		}else if("/fileupload.do".equals(path)){
			fileupload(req,res);
		}
		else{
			throw new RuntimeException("娌℃湁杩欎釜椤甸潰");
		}
	}
	//鐧诲綍
		protected void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		}

		protected void createImg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// 鐢熸垚楠岃瘉鐮�
			Object[] objs = ImageUtil.createImage();
			// 灏嗛獙璇佺爜鍜屽浘鐗囧瓨鍏�
			HttpSession session = req.getSession();
			session.setAttribute("imgcode", objs[0]);
			System.out.println(objs[0]);
			BufferedImage Image = (BufferedImage) objs[1];
			// 鎶婂浘杈撳嚭鍒扮綉椤典笂
			res.setContentType("image/png");
			OutputStream os = res.getOutputStream();
			ImageIO.write(Image, "png", os);
			os.close();

		}
	//鍙栧垽鏂�
		protected void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			AdDao cd = new AdDao();
			String name = req.getParameter("name");
			String mm = req.getParameter("mm");
			String code = req.getParameter("code");
			System.out.println(code);
			System.out.println("name:"+name);
			System.out.println(mm);
			Admin ad = cd.findAll(name);
			System.out.println(ad);
			HttpSession session = req.getSession();
			String imgcode = (String) session.getAttribute("imgcode");
			System.out.println(imgcode);
			if (code == null || !code.equalsIgnoreCase(imgcode)) {
				req.setAttribute("Error", "楠岃瘉鐮侀敊璇�");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
				return;
			}else if (ad == null) {
				String eror = "甯愬彿閿欒";
				req.setAttribute("Error", eror);
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			} else if (name.equals(ad.getAdmin_code()) && mm.equals(ad.getPassword())) {
				// 灏嗗笎鍙峰瓨鍏ookie
				Cookie c = new Cookie("user", name);
				res.addCookie(c);

				// 涔熷彲灏嗗笎鍙峰瓨鍏ession
				session.setAttribute("user", name);
				res.sendRedirect("toIndex.do");

			} else {
				String error = "璇蜂粠鏂拌緭鍏�";
				req.setAttribute("Error", error);
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			}
		}
	//鎼滅储妗屽悕
	private void tableName(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
				String tableName = req.getParameter("keyword");
				dinnerTableDao dao = new dinnerTableDao();
				List<dinnerTable> list = dao.findByName(tableName);
				req.setAttribute("tabless", list);		
				req.getRequestDispatcher("WEB-INF/service/boardList.jsp").forward(req, res);
	}
	//鎾ゆ帀/鍒犻櫎椁愭
	private void deltable(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String id = req.getParameter("id");
			dinnerTableDao dao = new dinnerTableDao();
			dao.delete(new Integer(id));
			// 閲嶅畾鍚戝埌鏌ヨ
			res.sendRedirect("toBoardList.do");
	}
	//淇敼涓虹姸鎬佸拰棰勮鏃堕棿
	private void updateTable(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		dinnerTableDao dao = new dinnerTableDao();
		dao.update(new Integer(id));
		// 閲嶅畾鍚戝埌鏌ヨ
		res.sendRedirect("toBoardList.do");

	}
	// 澶勭悊娣诲姞鏂伴妗屼俊鎭�(澧炲姞涓�鏉￠妗屼俊鎭�)
	private void inserttable(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String tableName = req.getParameter("tableName");
			dinnerTable d = new dinnerTable();
			d.setTableName(tableName);
			if (tableName != null && !tableName.equals(""))
				d.setTableName(new String(tableName));
			dinnerTableDao dao = new dinnerTableDao();
			dao.insert(d);
			// 閲嶅畾鍚戝埌鏌ヨ
			res.sendRedirect("toBoardList.do");
	}
	protected void toIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/service/index.jsp").forward(req,res);
	}
	// 鎵�鏈夐妗屽垪琛�
	protected void toBoardList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			dinnerTableDao dao = new dinnerTableDao();
			List<dinnerTable> list = dao.findall();
			req.setAttribute("tables", list);
			System.out.println(list);
			req.getRequestDispatcher("WEB-INF/service/boardList.jsp").forward(req, res);
	}
	// 鎵撳紑娣诲姞鏂伴妗岄〉闈�
	private void toinserttable(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/service/saveBoard.jsp").forward(req, res);

	}
	//鍘昏彍绯昏〃
		protected void toCuisineList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			CuisineDao dao = new CuisineDao();
			List<Cuisine> list = dao.findAll();
			System.out.println(list);
			req.setAttribute("cuisine",list);
			
			req.getRequestDispatcher("WEB-INF/service/cuisineList.jsp").forward(req,res);
		}
	//鑿滃搧鏌ヨ
	protected void toFoodList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Variteydao dao = new Variteydao();
		List<Variety> list = dao.getVariety();
		req.setAttribute("Variety", list);
//		for (Variety variety : list) {
//			System.out.println(variety);
//		}
		req.getRequestDispatcher("WEB-INF/service/foodList.jsp").forward(req,res);
	}
	protected void toFrderList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		OrderDao dao = new OrderDao();
		List<Order> list = dao.findAll();
		System.out.println(list);
		req.setAttribute("list", list);
		for (Order order : list) {
			System.out.println(order);
		}
		req.getRequestDispatcher("WEB-INF/service/orderList.jsp").forward(req,res);
	}
	protected void toOrderDetail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		OrderDetailDao dao = new OrderDetailDao();
		int id = Integer.parseInt(req.getParameter("id"));
		List<Detail> list = dao.findAll(id);
		req.setAttribute("list",list);
		req.getRequestDispatcher("WEB-INF/service/orderDetail.jsp").forward(req,res);
	}
	//鐐瑰嚮娣诲姞
	protected void toSaveFood(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Variteydao dao = new Variteydao();
		List<String> list = dao.getcaixi();
		System.out.println(list);
		req.setAttribute("caixi", list);
		req.getRequestDispatcher("WEB-INF/service/saveFood.jsp").forward(req,res);
	}
	//娣诲姞
	protected void SaveFood(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Variety v = GetAll(req);
		Variteydao dao = new Variteydao();
		dao.SvaeFood(v);
		res.sendRedirect("toFoodList.do");
	}
	private Variety GetAll(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String cid = req.getParameter("cid");
		String name = req.getParameter("foodName");
		Double price = Double.valueOf(req.getParameter("price"));
		Double mprice = Double.valueOf(req.getParameter("mprice"));
		String remark = req.getParameter("introduce");
		//String introduce = req.getParameter("introduce");
		//String imageUrl = req.getParameter("imageUrl");鍥剧墖娌″仛濂斤紵
		//System.out.println(imageUrl);
		Variety v = new Variety();
		v.setFoodType_id(cid);
		v.setFoodName(name);
		v.setPrice(price);
		v.setMprice(mprice);
		v.setRemark(remark);
		return v;
	}
	//鍒犻櫎
	protected void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		Variteydao dao = new Variteydao();
		dao.delete(id);
		res.sendRedirect("toFoodList.do");
	}
	//鐐瑰嚮鏇存柊
	protected void toUpdateFood(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		Variteydao dao = new Variteydao();
		Variety list = dao.getAll(id);
		List<String> list1 = dao.getcaixi();
		System.out.println("list:"+list);
		System.out.println("list1:"+list1);
		req.setAttribute("c", list);
		req.setAttribute("c1", list1);
		req.getRequestDispatcher("/WEB-INF/service/updateFood.jsp").forward(req, res);
	}
	//鐐瑰嚮淇敼
	protected void UpdateFood(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Variety v = GetAll(req);
		Integer id = Integer.valueOf(req.getParameter("id"));
		String img = req.getParameter("imageUrl");
		ServletInputStream img1 = req.getInputStream();
		System.out.println(img);
		v.setId(id);
		Variteydao dao = new Variteydao();
		dao.UpdateFood(v);
		res.sendRedirect("toFoodList.do");
	}
	//鎼滅储
	protected void sousuoFood(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String caixi = req.getParameter("keyword");
		Variteydao dao = new Variteydao();
		List<Variety> list = dao.getcaixi(caixi);
		req.setAttribute("caixi", list);
		req.getRequestDispatcher("/WEB-INF/service/foodList.jsp").forward(req, res);
	}
	//鍘绘洿鏂拌彍绯婚〉闈�
		protected void viewUpdate(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			req.setCharacterEncoding("utf-8");
			Cuisine c = new Cuisine();
			Integer id = Integer.valueOf(req.getParameter("id"));
			String foodtype = req.getParameter("type");
//			System.out.println(id);
//			System.out.println(foodtype);
			c.setFoodtype(foodtype);
			c.setId(id);
//			System.out.println(c.getFoodtype());
//			System.out.println(c.getId());
			req.setAttribute("cuisine", c);
			req.getRequestDispatcher("WEB-INF/service/updateCuisine.jsp").forward(req, res);
		}
		//鏇存柊鑿滅郴
		protected void update(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			req.setCharacterEncoding("utf-8");
			CuisineDao dao = new CuisineDao();
			Cuisine c = new Cuisine();
			Integer id = Integer.valueOf(req.getParameter("cid"));
			String foodtype = req.getParameter("foodType");
			c.setFoodtype(foodtype);
			c.setId(id);
			dao.update(c);
			res.sendRedirect("toCuisineList.do");
		}
		//鍒犻櫎鑿滅郴
		protected void delCuisine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			CuisineDao dao = new CuisineDao();
			Cuisine c = new Cuisine();
			Integer id = Integer.valueOf(req.getParameter("id"));
			String foodtype = req.getParameter("type");
			c.setId(id);
			c.setFoodtype(foodtype);
			dao.deletecaixi(c);
			dao.deletecaiping(c);
			System.out.println(c.getFoodtype());
			res.sendRedirect("toCuisineList.do");
		}
		//娣诲姞鑿滅郴
		protected void saveCuisine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			req.setCharacterEncoding("utf-8");
			CuisineDao dao = new CuisineDao();
			Cuisine c = new Cuisine();
			String foodtype = req.getParameter("foodtype");
			c.setFoodtype(foodtype);
			dao.add(c);
			res.sendRedirect("toCuisineList.do");	
		}
		//鍘绘坊鍔犺彍绯婚〉闈�
		protected void toAddCuisine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			req.getRequestDispatcher("WEB-INF/service/saveCuisine.jsp").forward(req, res);
		}
		protected void fileupload(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			Variteydao dao = new Variteydao();
			Variety v = new Variety();
			//判断提交过来的表单是否为文件上传表单。
			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			if(isMultipart){
				//构造一个文件上传处理对象
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				//定义一个迭代器
				Iterator items;
				//解析出表单中提交的所有文件内容
				try{
					items  = upload.parseRequest( req).iterator();
					while(items.hasNext()){ //判断当前元素是否存在，并且指向下一个元素(及所谓的索引)
						FileItem item = (FileItem)items.next();       //返回当前元素
						//判断参数域是普通的表单输入域,还是文件上传域
						//如果是文件输入域返回false
						if(!item.isFormField()){
							String fileName = item.getName();
						//获取context
							ServletContext context = getServletContext();
						//获取upload文件的绝对路径
							String path = context.getRealPath("upload");
							System.out.println("文件的名字为:"+fileName);
//							System.out.println("文件路径:"+path);
						//构造上传文件的路径
							Date d = new Date();
							Long l = d.getTime();
							File uploadFile = new File(path+File.separator+l+fileName);
							//获取文件大小
							Long size = item.getSize();
						//把上传的文件存储到服务器中，完成上传操作
							item.write(uploadFile);
							v.setImg(l+fileName);
							System.out.println("v:"+v);
						}else{
							String name = item.getFieldName();
							String value = new String(item.getString("iso8859-1").getBytes("iso8859-1"),"utf-8");
							//菜系
							String cx = req.getParameter("cid");
							//菜名
							String cm = req.getParameter("foodName");
							//价格
							String jg = req.getParameter("price");
							//会员价
							String hyj = req.getParameter("mprice");
							//简介
							String jj  = req.getParameter("introduce");
							if(name.equals("cid")){
								v.setFoodType_id(value);
							}else if(name.equals("foodName")){
								v.setFoodName(value);
							}else if(name.equals("introduce")){
								v.setRemark(value);
							}else if(name.equals("price")){
								v.setPrice(new Double(value));
							}else if(name.equals("mprice")){
								v.setMprice(new Double(value));
							}
							System.out.println("getFieldName:"+item.getFieldName());
							System.out.println("getString:"+new String(item.getString("iso8859-1").getBytes("iso8859-1"),"utf-8"));
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException("错误",e);
				}
				}
			dao.SvaeFood(v);
			res.sendRedirect("toFoodList.do");
		}
		
}
