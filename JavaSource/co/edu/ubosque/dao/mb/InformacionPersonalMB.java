package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.edu.ubosque.logic.ExperienciaLaboralLogica;
import co.edu.ubosque.logic.InformacionPersonalLogica;
import co.edu.ubosque.model.InformacionPersonal;

@ManagedBean
@SessionScoped
public class InformacionPersonalMB {

	private InformacionPersonalLogica logica;
	private List<InformacionPersonal> listaInformacion;
	private List<InformacionPersonal> perfilAmodificar;
	private InformacionPersonal informacionPersonalACrear;
	private InformacionPersonal informacionPersonalAModificar;
	private InformacionPersonal informacionPersonalAEliminar;
	private InformacionPersonal validarInformacionPersonal;
	private InformacionPersonal loginInformacion;	
	private InformacionPersonal perfil;

	private String descripcionPersona;
	private String nombrePersona;
	private String apellidoPersona;
	private String cedulaPersona;
	private String fechaNacimiento;
	private String generoPersona;
	private String estadoCivilPersona;
	private String departamentoPersona;
	private String numeroTelefonoPersona;
	private String direccionPersona;
	private String correoPersona;
	
	
	public InformacionPersonalMB() {

		validarInformacionPersonal		= new InformacionPersonal();
		perfil 							= new InformacionPersonal();
		informacionPersonalACrear 		= new InformacionPersonal();
		informacionPersonalAModificar 	= new InformacionPersonal();
		logica 							= new InformacionPersonalLogica();
		listaInformacion 				= logica.readInformacionPersonal();
		

		descripcionPersona= (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("descripcionPersona");

		nombrePersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("nombrePersona");

		apellidoPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("apellidoPersona");

		cedulaPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("cedulaPersona");

		fechaNacimiento = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("fechaNacimiento");

		generoPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("generoPersona");

		estadoCivilPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("estadoCivilPersona");

		departamentoPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("departamentoPersona");

		numeroTelefonoPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("numeroTelefonoPersona");

		direccionPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("direccionPersona");
		correoPersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("correoPersona");

		loginInformacion = (InformacionPersonal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginInformacion");

	}

	public String guardarInformacionPersonal( ) {

		String basico = null;

		try {
			
			if ( !informacionPersonalACrear.getDescripcion().isEmpty()) {
				
				logica.CreateInformacionPersonal(informacionPersonalACrear);
				listaInformacion = logica.readInformacionPersonal();

				basico = "/informacionUsuario/perfilUsuario";
				cargarInformacion(informacionPersonalACrear.getIdentificacion());
				
			} else if ( informacionPersonalACrear.getDescripcion() .isEmpty() ) {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ADVERTENCIA:",  "Debe diligenciar todos los campos"));
			}	

		} catch (Exception e) {
			System.out.println(e);
		}
		return basico;
	}

	public String validarInformacionCreada() {

		if ( logica.validarInformacionCreada(informacionPersonalACrear) == null ) {
			return guardarInformacionPersonal();

		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ADVERTENCIA:",  "Esta informacion ya existe"));

		}
		return "/informacionUsuario/perfilUsuario";
	}

	public String actualizarInformacionPersonal() {
		
		logica.updateInformacionPersonal(informacionPersonalAModificar);
		listaInformacion = logica.readInformacionPersonal();
				
		return "/informacionUsuario/perfilUsuario";
	}
	
	public String cargarInformacion( long cedula ) {

		String pagina = null;

		validarInformacionPersonal.setIdentificacion(cedula);

		loginInformacion = logica.validarInformacion(validarInformacionPersonal);	
		
		if ( logica.validarInformacion(validarInformacionPersonal) != null) {

			descripcionPersona 	= logica.validarInformacion(validarInformacionPersonal).getDescripcion()+ "";
			nombrePersona 		= logica.validarInformacion(validarInformacionPersonal).getNombres()+ "";
			apellidoPersona 	= logica.validarInformacion(validarInformacionPersonal).getApellidos()+ "";
			cedulaPersona 		= logica.validarInformacion(validarInformacionPersonal).getIdentificacion()+ "";			
			fechaNacimiento 	= logica.validarInformacion(validarInformacionPersonal).getFechaNacimiento()+ "";			
			generoPersona 		= logica.validarInformacion(validarInformacionPersonal).getGenero()+ "";
			estadoCivilPersona 	= logica.validarInformacion(validarInformacionPersonal).getEstadoCivil()+ "";
			departamentoPersona = logica.validarInformacion(validarInformacionPersonal).getLugarNacimiento()+ "";
			numeroTelefonoPersona = logica.validarInformacion(validarInformacionPersonal).getTelefono()+ "";
			direccionPersona 	= logica.validarInformacion(validarInformacionPersonal).getDireccion()+ "";
			correoPersona 		= logica.validarInformacion(validarInformacionPersonal).getCorreo() + "";
									
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("descripcionPersona",
					descripcionPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombrePersona",
					nombrePersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("apellidoPersona",
					apellidoPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cedulaPersona",
					cedulaPersona);	

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("fechaNacimiento",
					fechaNacimiento);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("generoPersona",
					generoPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("estadoCivilPersona",
					estadoCivilPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("departamentoPersona",
					departamentoPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroTelefonoPersona",
					numeroTelefonoPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("direccionPersona",
					direccionPersona);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("correoPersona",
					correoPersona);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginInformacion",
					loginInformacion);				
						
			pagina = "/informacionUsuario/perfilUsuario";				
			

		} else if (logica.validarInformacion(validarInformacionPersonal) == null) {
			pagina = "/informacionUsuario/crearInformacionPersonal";

		}
		return pagina;
	}

	public boolean validarInformacion(  ) {

		try {
			
			int cedula = (int) Long.parseLong(cedulaPersona);
			
			perfilAmodificar = logica.cargarPerfil(cedulaPersona);
			
			return true;
			
		} catch (Exception e) {
			return true;
		}	
		
	}
	
	public String pagina () {
		
		String pagina = "/informacionUsuario/actualizarInformacionPersonal";
		
		return pagina;
		
	}

	public void borrarInformacionPersonal() {

		logica.deleteInformacionPersonal(informacionPersonalAEliminar);
		listaInformacion = logica.readInformacionPersonal();
	}

	public String inicializarInformacionPersonal() {

		informacionPersonalACrear = new InformacionPersonal();

		return "/informacionUsuario/crearInformacionPersonal";
	}

	public InformacionPersonalLogica getLogica() {
		return logica;
	}

	public void setLogica(InformacionPersonalLogica logica) {
		this.logica = logica;
	}

	public List<InformacionPersonal> getListaInformacion() {
		return listaInformacion;
	}


	public void setListaInformacion(List<InformacionPersonal> listaInformacion) {
		this.listaInformacion = listaInformacion;
	}

	public InformacionPersonal getInformacionPersonalACrear() {
		return informacionPersonalACrear;
	}

	public void setInformacionPersonalACrear(InformacionPersonal informacionPersonalACrear) {
		this.informacionPersonalACrear = informacionPersonalACrear;
	}

	public InformacionPersonal getInformacionPersonalAModificar() {
		return informacionPersonalAModificar;
	}

	public void setInformacionPersonalAModificar(InformacionPersonal informacionPersonalAModificar) {
		this.informacionPersonalAModificar = informacionPersonalAModificar;
	}

	public InformacionPersonal getInformacionPersonalAEliminar() {
		return informacionPersonalAEliminar;
	}

	public void setInformacionPersonalAEliminar(InformacionPersonal informacionPersonalAEliminar) {
		this.informacionPersonalAEliminar = informacionPersonalAEliminar;
	}

	public InformacionPersonal getValidarInformacionPersonal() {
		return validarInformacionPersonal;
	}

	public void setValidarInformacionPersonal(InformacionPersonal validarInformacionPersonal) {
		this.validarInformacionPersonal = validarInformacionPersonal;
	}

	public InformacionPersonal getLoginInformacion() {
		return loginInformacion;
	}

	public void setLoginInformacion(InformacionPersonal loginInformacion) {
		this.loginInformacion = loginInformacion;
	}

	public String getCedulaPersona() {
		return cedulaPersona;
	}

	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGeneroPersona() {
		return generoPersona;
	}

	public void setGeneroPersona(String generoPersona) {
		this.generoPersona = generoPersona;
	}

	public String getEstadoCivilPersona() {
		return estadoCivilPersona;
	}

	public void setEstadoCivilPersona(String estadoCivilPersona) {
		this.estadoCivilPersona = estadoCivilPersona;
	}

	public String getDepartamentoPersona() {
		return departamentoPersona;
	}

	public void setDepartamentoPersona(String departamentoPersona) {
		this.departamentoPersona = departamentoPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public String getDescripcionPersona() {
		return descripcionPersona;
	}

	public void setDescripcionPersona(String descripcionPersona) {
		this.descripcionPersona = descripcionPersona;
	}

	public String getNumeroTelefonoPersona() {
		return numeroTelefonoPersona;
	}

	public void setNumeroTelefonoPersona(String numeroTelefonoPersona) {
		this.numeroTelefonoPersona = numeroTelefonoPersona;
	}

	public List<InformacionPersonal> getPerfilAmodificar() {
		return perfilAmodificar;
	}

	public void setPerfilAmodificar(List<InformacionPersonal> perfilAmodificar) {
		this.perfilAmodificar = perfilAmodificar;
	}

	public InformacionPersonal getPerfil() {
		return perfil;
	}

	public void setPerfil(InformacionPersonal perfil) {
		this.perfil = perfil;
	}

	public String getCorreoPersona() {
		return correoPersona;
	}

	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}

}
