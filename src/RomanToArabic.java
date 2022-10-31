public enum RomanToArabic {
    Ⅰ(1),Ⅱ(2),Ⅲ(3),Ⅳ(4),Ⅴ(5),Ⅵ(6),Ⅶ(7),Ⅷ(8),Ⅸ(9),Ⅹ(10);
    private int arabic;
    RomanToArabic(int arabic){
        this.arabic = arabic;

    }

    public int getArabic(){
        return this.arabic;
    }

}

