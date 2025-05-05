package in.cdac.mhealth.services;

import in.cdac.mhealth.department.business.DepartmentBO;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/department")
public class DepartmentService {
	
	
	
	@POST
	@Path("/regdeptlist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRegistrationDepartments(@FormParam("hospId") String hospId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartmentsForRegistration(hospId);
	}
	
	@GET
	@Path("/regdeptlist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRegistrationDepartment(@QueryParam("hospId") String hospId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartmentsForRegistration(hospId);
	}
	
	
	
	
	@POST
	@Path("/regcategorylist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRegistrationCategories(@FormParam("hospId") String hospId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getCategoriesForRegistration(hospId);
	}
	
	@GET
	@Path("/regcategorylist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRegistrationCategory(@QueryParam("hospId") String hospId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getCategoriesForRegistration(hospId);
	}
	
	
	
	
	
			
	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartments(){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartments();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartment(){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartments();
	}
		
	@GET
	@Path("/deptId")
	@Produces({MediaType.TEXT_PLAIN})
	public String getDepartment(@QueryParam("deptId") String deptId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartment(deptId);
	}
	
	@POST
	@Path("/deptDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartmentDetail(@FormParam("deptId") String deptId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartmentDetail(deptId);
	}
	
	@GET
	@Path("/deptDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartmentDTL(@QueryParam("deptId") String deptId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartmentDetail(deptId);
	}
	
	@POST
	@Path("/deptListUserName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartmentListByUserName(@FormParam("userId") String userId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartmentsByUserName(userId);
	}
	
	@GET
	@Path("/deptListUserName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartmentListByUserID(@QueryParam("userId") String userId){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getDepartmentsByUserName(userId);
	}
	
	@POST
	@Path("/unit/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String postUnitListByUserName(@FormParam("userId") String userId,
										@FormParam("hash") String hash,
										@FormParam("hcode") String hcode){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getUnitListByUserName(userId, hash, hcode);
	}
	
	@GET
	@Path("/unit/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUnitListByUserName(@QueryParam("userId") String userId,
										@QueryParam("hash") String hash,
										@QueryParam("hcode") String hcode){
		DepartmentBO objDepartmentBO = new DepartmentBO();
		return objDepartmentBO.getUnitListByUserName(userId, hash, hcode);
	}
}
