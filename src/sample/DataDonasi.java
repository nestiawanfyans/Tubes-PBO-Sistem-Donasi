package sample;

public class DataDonasi {
    private String judulDonasi = "Anak yang Terlantar";
    private String penyelenggara  = "Rumah yatim";
    private Double danaTerkumpul = 434250.00;
    private Double danaTarget = 2000000d;
    private int targethari = 62;

    public void setJudulDonasi(String judulDonasi){
        this.judulDonasi = judulDonasi;
    }
    public void setPenyelenggara(String penyelenggara){
        this.penyelenggara = penyelenggara;
    }
    public void setDanaTerkumpul(Double danaTerkumpul){
        this.danaTerkumpul = danaTerkumpul;
    }
    public void setDanaTarget(Double danaTarget){
        this.danaTarget = danaTarget;
    }
    public void setTargethari(int targethari){
        this.targethari = targethari;
    }

    public String getJudulDonasi(){
        return this.judulDonasi;
    }
    public String getPenyelenggara(){
        return this.penyelenggara;
    }
    public Double getDanaTerkumpul(){
        return this.danaTerkumpul;
    }
    public Double getDanaTarget(){
        return this.danaTarget;
    }
    public int getTargethari(){
        return this.targethari;
    }
}
