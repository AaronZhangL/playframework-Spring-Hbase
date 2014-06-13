package controllers;

import static play.data.Form.form;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import play.libs.F.Function;
import play.libs.F.Function0;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import service.JsonService;
import views.html.home;


@Component
public class Application extends Controller {

	@Autowired
	private JsonService js;

	/*
	 * first page
	 */
	public Result index() {

		return ok(home.render());
	}

	public Result hbaseGet() throws IOException {
		//String val = request.getParameter("GETForm");
		String val =form().bindFromRequest().get("getvalue");
		


		return ok(js.generateJson(val));
	}
	public Result hbasePost() throws IOException {
		//String val = request.getParameter("POSTForm");
		String val =form().bindFromRequest().get("postvalue");
		

		return ok(js.generateJson(val));
	}
	
	/**
	 * Async
	 * @return
	 * @throws IOException
	 */
	public Promise<Result> hbaseGetAsyn() throws IOException {
		Promise<String> pVal = Promise.promise(
				new Function0<String>() {
					public String apply() throws IOException {
						String val =form().bindFromRequest().get("getasynvalue");
						
						return js.generateJson(val).toString();
					}
				}
				);

		return pVal.map(
				new Function<String, Result>() {
					public Result apply(String val) {
						return ok(val);
					}
				}
				);
	}


}






