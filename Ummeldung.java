public class Ummeldung
{
    Stadt S;
    Buergerin B;
    Adresse A;
    int P;
    /*  public Ummeldung(Stadt s, Buergerin b, Adresse a, int p)
    {
        this.S = s;
        this.B = b;
        this.A = a;
        this.P = p;
    }
    */

    public static void Ausgabe(Stadt s)
    {
        System.out.println("In "+ s.Name + " sind " + s.zahlDerGemeldeten + " Bürger*innen gemeldet.");
    }
    
    public static void Ausgabe2(int p)
    {
        System.out.println("Es gibt im Land insgesmat "+ p +" Menschen.");
    }

    public static void Die_jetzige_Adresse(Buergerin b, Adresse a)
    {
        System.out.println(""+ b.vorname +" "+ b.name + " wohnt nun hier:\n/\n" + a.strassenname +" "+ a.nummer
                        + "\n" + a.postleitzahl+" "+ a.ort.Name + "\n/");
        System.out.println("====================");
    }

    static class Stadt
    {
        String Name;
        int zahlDerGemeldeten;
        public Stadt(String n, int e)
        {
            Name = n;
            zahlDerGemeldeten = e;
        }

        public void erstelleMeldebescheinigung(Buergerin b)
        {
            b.adresse.ort.zahlDerGemeldeten += 1;
            System.out.println("" + b.vorname +" "+b.name + " ist nun in " + b.adresse.ort.Name + " offiziell gemeldet.");
            System.out.println("====================");
        }
    }

    static class Buergerin
    {
        String name;
        String vorname;
        boolean gemeldet;
        Adresse adresse;
        int population;

        public boolean getgemeldet()
        {
            return gemeldet;
        }

        public void setgemeldet(boolean neuGemldet)
        {
            this.gemeldet = neuGemldet;
        }

/*         public int getpopulation()
        {
            return population;
        }

        public void setpopulation(int neuPopulation)
        {
            this.population = neuPopulation;
        } */

        public Buergerin(String n, String v, boolean g, Adresse a)
        {
            name = n;
            vorname = v;
            gemeldet = g;
            adresse = a;
        } 

        public void zieheUmnach(Adresse neu, boolean gemeldet)
        {
            if (gemeldet)
            {
                //adresse.ort.zahlDerGemeldeten -= 1;
                System.out.println("" + vorname
                        +" "+ name
                        + " zieht von\n"
                        + "/\n"
                        + adresse.strassenname +" "+ adresse.nummer
                        + "\n"
                        + adresse.postleitzahl +" "+ adresse.ort.Name
                        + "\n/\n"
                        + "nach"
                        + "\n/\n"
                        + neu.strassenname +" "+ neu.nummer
                        + "\n"
                        + neu.postleitzahl +" "+ neu.ort.Name
                        + "\n/");
                System.out.println("====================");

                adresse = neu;
            }
                
        }

        public void beantrageMeldebescheinigung(Stadt s)
        {
            System.out.println("" + vorname +" "+name + " stellt einen Antrag zur Ummeldung nach " + s.Name+".");
            if (!gemeldet)
            {
                System.out.println("Antrag zur Meldung in " + s.Name + " ist nicht berechtigt");
                System.out.println("====================");
            }
            
            else
            {
                s.erstelleMeldebescheinigung(new Buergerin(name, vorname, gemeldet, adresse));
            }
        }
    }

    static class Adresse
    {
        String strassenname;
        int nummer;
        String postleitzahl;
        Stadt ort;

        public Adresse(String s, int n, String p, Stadt o)
        {
            strassenname = s;
            nummer = n;
            postleitzahl = p;
            ort = o;
        }
}
    public static void main(String[] argv)
    {
        
        Stadt wuppertal =new Stadt("Wuppertal", 350000);
        Stadt duesseldorf = new Stadt("Duesseldorf", 700000);
        Stadt dortmund = new Stadt("Dortmund", 550000);
        int popul = duesseldorf.zahlDerGemeldeten + wuppertal.zahlDerGemeldeten + dortmund.zahlDerGemeldeten;
        Ummeldung.Ausgabe(wuppertal);
        Ummeldung.Ausgabe(duesseldorf);
        Ummeldung.Ausgabe(dortmund);
        Ummeldung.Ausgabe2(popul);
        System.out.println("Folgende Bürger*innen kommen _neu_ ins Land hinzu\n(sind zunächst aber nicht gemeldet!");  
        /*
        System.out.println("In " + wuppertal.Name + " sind " + wuppertal.zahlDerGemeldeten + " Bürger*innen gemeldet.");
        System.out.println("In " + duesseldorf.Name + " sind " + duesseldorf.zahlDerGemeldeten + " Bürger*innen gemeldet.");
        System.out.println("In "+ dortmund.Name + " sind " + dortmund.zahlDerGemeldeten + " Bürger*innen gemeldet.");
        */
        Adresse adres1 = new Adresse("Koenigsalle", 1, "40212", duesseldorf);
        Adresse adres2 = new Adresse("Gaußstraße", 20, "42119", wuppertal);
        Adresse adres3 = new Adresse("Koenigswall", 2, "44137", dortmund);
        Buergerin Ada_Lovelace = new Buergerin("Lovelace", "Ada", false, adres1);
        Die_jetzige_Adresse(Ada_Lovelace, Ada_Lovelace.adresse);
        //Ada_Lovelace.setpopulation(Ada_Lovelace.adresse.ort.zahlDerGemeldeten);
        Buergerin Peter_Naur = new Buergerin("Naur", "Peter", true, adres3);
        Die_jetzige_Adresse(Peter_Naur, Peter_Naur.adresse);
        Ada_Lovelace.beantrageMeldebescheinigung(wuppertal);
        Ada_Lovelace.setgemeldet(true);
        Ada_Lovelace.zieheUmnach(adres2, Ada_Lovelace.getgemeldet());
        Die_jetzige_Adresse(Ada_Lovelace, Ada_Lovelace.adresse);
        Ada_Lovelace.beantrageMeldebescheinigung(wuppertal);
        popul = duesseldorf.zahlDerGemeldeten + wuppertal.zahlDerGemeldeten + dortmund.zahlDerGemeldeten + 1;
        //Ummeldung a = new Ummeldung(Ada_Lovelace.adresse.ort, Ada_Lovelace, Ada_Lovelace.adresse, Ada_Lovelace.getpopulation());
        Ummeldung.Ausgabe(wuppertal);
        Ummeldung.Ausgabe(duesseldorf);
        Ummeldung.Ausgabe(dortmund);
        Ummeldung.Ausgabe2(popul);
        /*
        System.out.println("In " + wuppertal.Name + " sind " adresse.ort.+ wuppertal.zahlDerGemeldeten + " Bürger*innen gemeldet.");
        System.out.println("In " + duesseldorf.Name + " sind " + duesseldorf.zahlDerGemeldeten + " Bürger*innen gemeldet.");
        System.out.println("In "+ dortmund.Name + " sind " + dortmund.zahlDerGemeldeten + " Bürger*innen gemeldet.");
        */
    }
}