import java.util.ArrayList;

public class Empresa {
    private ArrayList<Persona> personas;

    public Empresa(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona) {
        if(!personaExiste(persona)) {
            this.personas.add(persona);
            System.out.println("Persona agregada correctamente.");
            return;
        }

        System.out.println("La persona ya está en la lista.");
    }

    public boolean personaExiste(Persona persona) {
        for (Persona p : this.personas) {
            if(persona.getRut().equals(p.getRut())) {
                return true;
            }
        }

        return false;
    }

    private void eliminarPersona(Persona persona) {
        if(personaExiste(persona)) {
            this.personas.remove(persona);
        }
    }

    public Persona obtenerPersonaPorRut(String rut) {
        for (Persona persona : this.personas) {
            if(persona.getRut().equals(rut)) {
                return persona;
            }
        }

        return null;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}
