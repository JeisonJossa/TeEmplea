package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import co.edu.ubosque.logic.ExperienciaLaboralLogica;
import co.edu.ubosque.logic.InformacionAcademicaLogica;
import co.edu.ubosque.logic.ReferenciasLogica;
import co.edu.ubosque.logic.UsuarioLogica;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.InformacionAcademica;
import co.edu.ubosque.model.Referencias;
import co.edu.ubosque.model.TeEmplea;
import co.edu.ubosque.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB {

	private UsuarioLogica logica;
	private List<Usuario> listaUsuarios;	
	private Usuario usuarioACrear;
	private Usuario usuarioAModificar;
	private Usuario usuarioAEliminar;
	private Usuario validarUsuario;
	private Usuario ciudadanoLogin;

	private String nombrePersona;
	private String correoPersona;
	private long cedulaPersona;
	
	private List<ExperienciaLaboral> experienciaLista;
	private InformacionPersonalMB informacion;
	private ExperienciaLaboralMB experiencia;
	private ExperienciaLaboralLogica logicaExperiencia;
	
	private List<InformacionAcademica> listaAcademica;
	private InformacionAcademicaLogica logicaAcademica;
	
	private List<Referencias> listaReferencias;
	private ReferenciasLogica logicaReferencias;
	
	private EmpresaMB empresa;

	public UsuarioMB() {

		validarUsuario 	= new Usuario();
		logica 			= new UsuarioLogica();
		listaUsuarios 	= logica.readUsuario();
		usuarioACrear 	= new Usuario();
		experiencia		= new ExperienciaLaboralMB();
		empresa 		= new EmpresaMB();
		informacion 	= new InformacionPersonalMB();	
		
		logicaExperiencia = new ExperienciaLaboralLogica();		
		logicaAcademica = new InformacionAcademicaLogica();		
		logicaReferencias = new ReferenciasLogica();

		nombrePersona = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("nombrePersona");
		ciudadanoLogin = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("ciudadanoLogin");

	}

	public String guardarUsuario( ) {
		
		try {
			
			TeEmplea correo = new TeEmplea();
			correo.enviarCorreo(usuarioACrear);
			
		} catch (Exception e) {
			
		}

		String	cuenta 		= "/crearCuenta/crearCuenta";
		String contrasena 	= DigestUtils.sha1Hex(usuarioACrear.getContrasena());
			
		usuarioACrear.setContrasena(contrasena);

		try {
			if ( ! ( usuarioACrear.getCorreo().isEmpty() && usuarioACrear.getContrasena().isEmpty() ) ) {				

				logica.CreateUsuario(usuarioACrear);
				listaUsuarios = logica.readUsuario();

				cuenta = "/login/login";
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return cuenta;
	}

	public String actualizarUsuario() {

		logica.updateUsuario(usuarioAModificar);
		listaUsuarios = logica.readUsuario();

		return "/crearCuenta/crearCuenta";
	}

	public void borrarUsuario() {

		logica.deleteUsuario(usuarioAEliminar);
		listaUsuarios = logica.readUsuario();
	}


	public String validarLogin() {

		String login = "/login/login";
		
		String contrasena = DigestUtils.sha1Hex(validarUsuario.getContrasena());
		
		validarUsuario.setContrasena(contrasena);
		
		ciudadanoLogin = logica.readLogin(validarUsuario);

		if ( logica.readLogin(validarUsuario) != null) {

			if (logica.readLogin(validarUsuario).getPerfil() == 1) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombrePersona",
						validarUsuario.getCorreo() + " " + validarUsuario.getIdentificacion());

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ciudadanoLogin",
						ciudadanoLogin);

				nombrePersona = logica.readLogin(validarUsuario).getIdentificacion() + "";
				correoPersona = logica.readLogin(validarUsuario).getCorreo() + "";

				cedulaPersona = logica.readLogin(validarUsuario).getIdentificacion();

				login = "/informacionUsuario/perfilUsuario?faces-redirect=true";
				informacion.cargarInformacion( cedulaPersona );				

				this.experiencia.cargarExperiencia(cedulaPersona);				

			} else if (logica.readLogin(validarUsuario).getPerfil() == 2) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombrePersona",
						" " + " " + validarUsuario.getIdentificacion());
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ciudadanoLogin",
						ciudadanoLogin);

				nombrePersona = logica.readLogin(validarUsuario).getIdentificacion() + "";
				correoPersona = logica.readLogin(validarUsuario).getCorreo() + "";

				cedulaPersona = logica.readLogin(validarUsuario).getIdentificacion();
				
				login = "/compania/perfilCompania";
				empresa.cargarInformacion(cedulaPersona);
			}
		}

		return login;
	}

	public boolean cargarExperiencia(  ) {

		int cedula1 = (int) cedulaPersona;
		try {

			experienciaLista = logicaExperiencia.cargarExperiencia(cedula1);							
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return true;
			
		} 

	}
	
	public boolean cargarAcademica( ) {
		
		int cedula1 = (int) cedulaPersona;
		
		try {
			
			listaAcademica = logicaAcademica.cargarAcademica(cedula1);
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return true;
		}
	}
	
	public boolean cargarReferencias( ) {
		
		int cedula1 = (int) cedulaPersona;
		
		try {
			
			listaReferencias = logicaReferencias.cargarReferencias(cedula1);
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return true;
		}
	}

	public String validarDatos() {

		if ( logica.validarDatos(usuarioACrear) == null ) {
			return guardarUsuario();

		} else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",  "Ya existe un usuario con estos datos registrados"));

		}
		return "/login/login";
	}

	public String inicializarUsuario() {

		usuarioACrear = new Usuario();

		return "/crearCuenta/crearCuenta";
	}

	public String cerrarLogin() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/index/index";
	}

	public boolean validarSesion() {

		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ciudadanoLogin") == null) {
			estado = false;
		} else {
			estado = true;
		}
		return estado;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Referencias> getListaReferencias() {
		return listaReferencias;
	}

	public void setListaReferencias(List<Referencias> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

	public ReferenciasLogica getLogicaReferencias() {
		return logicaReferencias;
	}

	public void setLogicaReferencias(ReferenciasLogica logicaReferencias) {
		this.logicaReferencias = logicaReferencias;
	}

	public Usuario getUsuarioACrear() {
		return usuarioACrear;
	}

	public void setUsuarioACrear(Usuario usuarioACrear) {
		this.usuarioACrear = usuarioACrear;
	}

	public Usuario getUsuarioAModificar() {
		return usuarioAModificar;
	}

	public void setUsuarioAModificar(Usuario usuarioAModificar) {
		this.usuarioAModificar = usuarioAModificar;
	}

	public Usuario getUsuarioAEliminar() {
		return usuarioAEliminar;
	}

	public void setUsuarioAEliminar(Usuario usuarioAEliminar) {
		this.usuarioAEliminar = usuarioAEliminar;
	}

	public UsuarioLogica getLogica() {
		return logica;
	}

	public void setLogica(UsuarioLogica logica) {
		this.logica = logica;
	}

	public Usuario getValidarUsuario() {
		return validarUsuario;
	}

	public void setValidarUsuario(Usuario validarUsuario) {
		this.validarUsuario = validarUsuario;
	}

	public Usuario getCiudadanoLogin() {
		return ciudadanoLogin;
	}

	public void setCiudadanoLogin(Usuario ciudadanoLogin) {
		this.ciudadanoLogin = ciudadanoLogin;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getCorreoPersona() {
		return correoPersona;
	}

	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}

	public long getCedulaPersona() {
		return cedulaPersona;
	}

	public void setCedulaPersona(long cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public InformacionPersonalMB getInformacion() {
		return informacion;
	}

	public void setInformacion(InformacionPersonalMB informacion) {
		this.informacion = informacion;
	}

	public ExperienciaLaboralMB getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ExperienciaLaboralMB experiencia) {
		this.experiencia = experiencia;
	}

	public List<ExperienciaLaboral> getExperienciaLista() {
		return experienciaLista;
	}

	public void setExperienciaLista(List<ExperienciaLaboral> experienciaLista) {
		this.experienciaLista = experienciaLista;
	}

	public ExperienciaLaboralLogica getLogicaExperiencia() {
		return logicaExperiencia;
	}

	public void setLogicaExperiencia(ExperienciaLaboralLogica logicaExperiencia) {
		this.logicaExperiencia = logicaExperiencia;
	}

	public List<InformacionAcademica> getListaAcademica() {
		return listaAcademica;
	}

	public void setListaAcademica(List<InformacionAcademica> listaAcademica) {
		this.listaAcademica = listaAcademica;
	}

	public InformacionAcademicaLogica getLogicaAcademica() {
		return logicaAcademica;
	}

	public void setLogicaAcademica(InformacionAcademicaLogica logicaAcademica) {
		this.logicaAcademica = logicaAcademica;
	}

}
