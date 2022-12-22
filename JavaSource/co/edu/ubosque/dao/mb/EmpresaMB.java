package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.edu.ubosque.logic.EmpresaLogica;
import co.edu.ubosque.model.Empresa;

@ManagedBean
@SessionScoped
public class EmpresaMB {

	private EmpresaLogica logica;
	private List<Empresa> listaIEmpresas;
	private List<Empresa> empresaAmodificar;
	private Empresa empresaACrear;
	private Empresa empresaAModificar;
	private Empresa empresaAEliminar;
	private Empresa validarInformacionEmpresa;
	private Empresa loginEmpresa;	
	private Empresa perfil;

	private String nombreEmpresa;
	private String rut;
	private String telefono;
	private String correo;
	private String desripcion;
	private String departamento;
	private String direccion;
	private String tipoCompañia;
	private String sector;
	private String pagina;
	private String nombres;
	private String apellidos;
	private String cargo;
	private String telefonoMovil;
	private String telefonoFijo;


	public EmpresaMB() {

		validarInformacionEmpresa		= new Empresa();
		perfil 							= new Empresa();
		empresaACrear 					= new Empresa();
		empresaAModificar 				= new Empresa();
		logica 							= new EmpresaLogica();
		listaIEmpresas 					= logica.readEmpresa();


		nombreEmpresa = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("nombreEmpresa");

		rut = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("rut");
		
		telefono = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("telefono");

		correo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("correo");

		desripcion = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("desripcion");

		departamento = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("departamento");

		direccion = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("direccion");

		tipoCompañia = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("tipoCompañia");

		sector = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("sector");

		pagina = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("pagina");

		nombres = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("nombres");

		apellidos = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("apellidos");

		cargo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("cargo");

		telefonoMovil = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("telefonoMovil");

		telefonoFijo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("telefonoFijo");

		loginEmpresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginEmpresa");

	}

	public String guardarInformacionPersonal( ) {

		String basico = null;

		try {

			if ( !empresaACrear.getCargo().isEmpty()) {

				logica.CreateEmpresa(empresaACrear);
				listaIEmpresas = logica.readEmpresa();

				basico = "/compania/perfilCompania";
				cargarInformacion(empresaACrear.getRut());
				
			} else if ( empresaACrear.getDireccion() .isEmpty() ) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ADVERTENCIA:",  "Debe diligenciar todos los campos"));
			}	

		} catch (Exception e) {
			System.out.println(e);
		}
		return basico;
	}

	public String validarEmpresaCreada() {

		if ( logica.validarInformacionCreada(empresaACrear) == null ) {
			return guardarInformacionPersonal();

		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ADVERTENCIA:",  "Esta informacion ya existe"));

		}
		return "/compania/perfilCompania";
	}

	public String actualizarInformacionPersonal() {

		logica.updateEmpresa(empresaAModificar);
		listaIEmpresas = logica.readEmpresa();

		return "/compania/perfilCompania";
	}

	public String cargarInformacion( long cedula ) {

		int rut1 = (int) cedula;

		String pagina1 = null;

		validarInformacionEmpresa.setRut(rut1);

		loginEmpresa = logica.validarInformacion(validarInformacionEmpresa);


		if ( logica.validarInformacion(validarInformacionEmpresa) != null) {

			nombreEmpresa 	= logica.validarInformacion(validarInformacionEmpresa).getNombreEmpresa() + "";
			rut 			= logica.validarInformacion(validarInformacionEmpresa).getRut() + "";
			telefono 		= logica.validarInformacion(validarInformacionEmpresa).getTelefono() + "";
			correo 			= logica.validarInformacion(validarInformacionEmpresa).getCorreo() + "";
			desripcion 		= logica.validarInformacion(validarInformacionEmpresa).getDesripcion() + "";
			departamento 	= logica.validarInformacion(validarInformacionEmpresa).getDepartamento() + "";
			direccion 		= logica.validarInformacion(validarInformacionEmpresa).getDireccion() + "";
			tipoCompañia 	= logica.validarInformacion(validarInformacionEmpresa).getTipoCompañia() + "";
			sector 			= logica.validarInformacion(validarInformacionEmpresa).getSector() + "";
			pagina 			= logica.validarInformacion(validarInformacionEmpresa).getPagina() + "";
			nombres 		= logica.validarInformacion(validarInformacionEmpresa).getNombres() + "";
			apellidos 		= logica.validarInformacion(validarInformacionEmpresa).getApellidos() + "";
			cargo 			= logica.validarInformacion(validarInformacionEmpresa).getCargo() + "";
			telefonoMovil 	= logica.validarInformacion(validarInformacionEmpresa).getTelefonoMovil() + "";
			telefonoFijo 	= logica.validarInformacion(validarInformacionEmpresa).getTelefonoFijo() + "";


			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombreEmpresa",
					nombreEmpresa);			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rut",
					rut);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("telefono",
					telefono);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("correo",
					correo);			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("desripcion",
					desripcion);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("departamento",
					departamento);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("direccion",
					direccion);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipoCompañia",
					tipoCompañia);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sector",
					sector);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pagina",
					pagina);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombres",
					nombres);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("apellidos",
					apellidos);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cargo",
					cargo);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("telefonoMovil",
					telefonoMovil);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("telefonoFijo",
					telefonoFijo);

			pagina = "/informacionUsuario/perfilUsuario";				


		} else if (logica.validarInformacion(validarInformacionEmpresa) == null) {
			pagina = "/informacionUsuario/crearInformacionPersonal";

		}
		return pagina1;
	}

	public boolean validarInformacion(  ) {

		int cedula = Integer.parseInt(rut);
		try {

			empresaAmodificar = logica.cargarPerfil(cedula);

			return true;

		} catch (Exception e) {

		}		
		return true;
	}

	public String pagina () {

		String pagina = "/informacionUsuario/actualizarInformacionPersonal";

		return pagina;

	}

	public void borrarInformacionPersonal() {

		logica.deleteEmpresa(empresaAEliminar);
		listaIEmpresas = logica.readEmpresa();
	}

	public String inicializarInformacionPersonal() {

		empresaACrear = new Empresa();

		return "/compania/registrocompania";
	}

	public EmpresaLogica getLogica() {
		return logica;
	}

	public void setLogica(EmpresaLogica logica) {
		this.logica = logica;
	}

	public List<Empresa> getListaIEmpresas() {
		return listaIEmpresas;
	}

	public void setListaIEmpresas(List<Empresa> listaIEmpresas) {
		this.listaIEmpresas = listaIEmpresas;
	}

	public List<Empresa> getEmpresaAmodificar() {
		return empresaAmodificar;
	}

	public void setEmpresaAmodificar(List<Empresa> empresaAmodificar) {
		this.empresaAmodificar = empresaAmodificar;
	}

	public Empresa getEmpresaACrear() {
		return empresaACrear;
	}

	public void setEmpresaACrear(Empresa empresaACrear) {
		this.empresaACrear = empresaACrear;
	}

	public Empresa getEmpresaAModificar() {
		return empresaAModificar;
	}

	public void setEmpresaAModificar(Empresa empresaAModificar) {
		this.empresaAModificar = empresaAModificar;
	}

	public Empresa getEmpresaAEliminar() {
		return empresaAEliminar;
	}

	public void setEmpresaAEliminar(Empresa empresaAEliminar) {
		this.empresaAEliminar = empresaAEliminar;
	}

	public Empresa getValidarInformacionEmpresa() {
		return validarInformacionEmpresa;
	}

	public void setValidarInformacionEmpresa(Empresa validarInformacionEmpresa) {
		this.validarInformacionEmpresa = validarInformacionEmpresa;
	}

	public Empresa getLoginEmpresa() {
		return loginEmpresa;
	}

	public void setLoginEmpresa(Empresa loginEmpresa) {
		this.loginEmpresa = loginEmpresa;
	}

	public Empresa getPerfil() {
		return perfil;
	}

	public void setPerfil(Empresa perfil) {
		this.perfil = perfil;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDesripcion() {
		return desripcion;
	}

	public void setDesripcion(String desripcion) {
		this.desripcion = desripcion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoCompañia() {
		return tipoCompañia;
	}

	public void setTipoCompañia(String tipoCompañia) {
		this.tipoCompañia = tipoCompañia;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
}
