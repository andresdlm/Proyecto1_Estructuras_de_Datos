package tatteo;


import java.io.*;

public class Repositorio {

    //Datos de vuelo
    private static String UbicacionRepoVuelos = null;
    private File repo_vuelos = new File(UbicacionRepoVuelos);
    private String[] lineaVuelo = new String[arrayLength];
    private int[] numeroVuelo = new int[lineaVuelo.length];
    private String[] aerolinea = new String[lineaVuelo.length];
    private int[] costoVuelo = new int[lineaVuelo.length];
    private int[] duracionVuelo = new int[lineaVuelo.length];

    //Datos de rutas de vuelo
    private static String UbicacionRepoRutas = null;
    private File repo_rutas = new File(UbicacionRepoRutas);
    private String[] lineaRuta = new String[arrayLength];
    private String[] origen = new String[lineaRuta.length];
    private String[] destino = new String[lineaRuta.length];
    private int[] numeroVueloRuta = new int[lineaRuta.length];

    //Datos de ciudad
    private static String UbicacionRepoCiudad = null;
    private File repo_ciudad = new File(UbicacionRepoCiudad);
    private String[] lineaCiudad = new String[arrayLength];
    private String[] ciudad = new String[lineaCiudad.length];
    private String[] aeropuerto = new String[lineaCiudad.length];
    private String[] pais = new String[lineaCiudad.length];

    public final static int arrayLength = 15;

    //Ingresar datos en Repositorio de Vuelos
    public void IngresarDatos(int numeroVuelo, String aerolinea, int costoVuelo, int duracionVuelo){
        try {

            FileWriter fileWriter = new FileWriter(repo_vuelos, true);
            fileWriter.write(numeroVuelo +","+ aerolinea +","+ costoVuelo +","+ duracionVuelo +"\r\n");
            fileWriter.close();

        }catch (IOException ex){
            System.out.println("No se ha encontrado el archivo");
        }
    }

    //Ingresar datos en Repositorio de Rutas
    public void IngresarDatos(String origen, String destino, int numeroVueloRuta){
        try {

            FileWriter fileWriter = new FileWriter(repo_rutas, true);
            fileWriter.write(origen +","+ destino + "," + numeroVueloRuta +"\r\n");
            fileWriter.close();

        }catch (IOException ex){
            System.out.println("No se ha encontrado el archivo");
        }
    }

    //Ingresar datos en Repositorio de Ciudades
    public void IngresarDatos(String Ciudad, String Aeropuerto, String Pais) {
        try {

            FileWriter fileWriter = new FileWriter(repo_ciudad, true);
            fileWriter.write(Ciudad +","+ Aeropuerto +","+ Pais + "\r\n");
            fileWriter.close();

        }catch (IOException ex){
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public int lineas_sin_null(File repositorio) throws IOException {
        int n =0;
        FileReader fileReader = new FileReader(repositorio);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for(int i = 0; i< arrayLength; i++){
            if((bufferedReader.readLine()) != null){
                n++;
            }
        }

        return n;
    }

    public void leerRepositorio(File repositorio, String[] linea) throws IOException {

        FileReader fileReader = new FileReader(repositorio);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lines;

        for(int i = 0; i< linea.length; i++){
            if(( lines = bufferedReader.readLine()) != null){
                linea[i] = lines;
            }
        }
        if(repositorio == repo_vuelos){
            SepararStringVuelo();
        }else if(repositorio == repo_rutas){
            SepararStringRuta();
        }else{
            SepararStringCiudad();
        }

    }

    private void SepararStringVuelo(){
        for (int i = 0; i < lineaVuelo.length; i++) {
            if(lineaVuelo[i] != null){
                numeroVuelo[i] = Integer.parseInt(lineaVuelo[i].split(",")[0]);
                aerolinea[i] = lineaVuelo[i].split(",")[1];
                costoVuelo[i] = Integer.parseInt(lineaVuelo[i].split(",")[2]);
                duracionVuelo[i] = Integer.parseInt(lineaVuelo[i].split(",")[3]);
            }
        }
    }

    private void SepararStringRuta(){
        for (int i = 0; i < lineaRuta.length; i++) {
            if(lineaRuta[i] != null){
                origen[i] = lineaRuta[i].split(",")[0];
                destino[i] = lineaRuta[i].split(",")[1];
                numeroVueloRuta[i] = Integer.parseInt(lineaRuta[i].split(",")[2]);
            }
        }
    }

    private void SepararStringCiudad(){
        for (int i = 0; i < lineaCiudad.length; i++) {
            if(lineaCiudad[i] != null){
                ciudad[i] = lineaCiudad[i].split(",")[0];
                aeropuerto[i] = lineaCiudad[i].split(",")[1];
                pais[i] = lineaCiudad[i].split(",")[2];
            }
        }
    }


    public int getNumeroVuelo(int i) {
        return numeroVuelo[i];
    }

    public String getAerolinea(int i) {
        return aerolinea[i];
    }

    public int getCostoVuelo(int i) {
        return costoVuelo[i];
    }

    public int getDuracionVuelo(int i) {
        return duracionVuelo[i];
    }

    public String getOrigen(int i) {
        return origen[i];
    }

    public String getDestino(int i) {
        return destino[i];
    }

    public int getNumeroVueloRuta(int i) { return numeroVueloRuta[i]; }

    public String getCiudad(int i) {
        return ciudad[i];
    }

    public String getAeropuerto(int i) {
        return aeropuerto[i];
    }

    public String getPais(int i) {
        return pais[i];
    }

    public File getRepo_vuelos() {
        return repo_vuelos;
    }

    public File getRepo_rutas() {
        return repo_rutas;
    }

    public File getRepo_ciudad() {
        return repo_ciudad;
    }

    public String[] getLineaVuelo() {
        return lineaVuelo;
    }

    public String[] getLineaRuta() {
        return lineaRuta;
    }

    public String[] getLineaCiudad() {
        return lineaCiudad;
    }

    public static void setUbicacionRepoVuelos(String ubicacionRepoVuelos) {
        UbicacionRepoVuelos = ubicacionRepoVuelos;
    }

    public static void setUbicacionRepoRutas(String ubicacionRepoRutas) {
        UbicacionRepoRutas = ubicacionRepoRutas;
    }

    public static void setUbicacionRepoCiudad(String ubicacionRepoCiudad) {
        UbicacionRepoCiudad = ubicacionRepoCiudad;
    }

    public static String getUbicacionRepoVuelos() {
        return UbicacionRepoVuelos;
    }

    public static String getUbicacionRepoRutas() {
        return UbicacionRepoRutas;
    }

    public static String getUbicacionRepoCiudad() {
        return UbicacionRepoCiudad;
    }
}
