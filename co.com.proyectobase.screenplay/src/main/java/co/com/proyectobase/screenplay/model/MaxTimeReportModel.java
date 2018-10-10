package co.com.proyectobase.screenplay.model;

public class MaxTimeReportModel {
	
	private String report_user;
	private String client_code;
	private String hour_type;
	private String service;
	private String activity;
	private String executed_hours;
	private String comment;
	
	public String getClient_code() {
		return client_code;
	}

	public void setClient_code(String client_code) {
		this.client_code = client_code;
	}

	public String getHour_type() {
		return hour_type;
	}

	public void setHour_type(String hour_type) {
		this.hour_type = hour_type;
	}

	public String getService() {
		return service.replace("\"", "");
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getExecuted_hours() {
		return executed_hours;
	}

	public void setExecuted_hours(String executed_hours) {
		this.executed_hours = executed_hours;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
			 
	public String getReport_user() {
		return report_user;
	}

	public void setReport_user(String report_user) {
		this.report_user = report_user;
	}	
}
