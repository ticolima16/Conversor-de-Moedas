import java.io.IOException;

public class Converte {
    private String base_moeda;
    private String converte_moeda;

    public Converte() {
        this.converte_moeda = "BRL";
        this.base_moeda = "USD";
    }

    public double converter(double valor) throws IOException, InterruptedException {
        Double cotacao = new Cotacaoes().buscarMoedas(getBase_moeda()).get(getConverte_moeda());
        double v;
        return valor * cotacao;

    }

    public String getBase_moeda() {
        return base_moeda;
    }

    public void setBase_moeda(String base_moeda) {
        this.base_moeda = base_moeda;
    }

    public String getConverte_moeda() {
        return converte_moeda;
    }

    public void setConverte_moeda(String converte_moeda) {
        this.converte_moeda = converte_moeda;
    }
}
