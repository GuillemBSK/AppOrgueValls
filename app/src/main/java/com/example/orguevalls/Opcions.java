package com.example.orguevalls;

public class Opcions {

    public static String question[] ={
            "Busqueu aquest carreu i situeu-lo al plànol. (Cal respondre per avançar)",
            "Quants escuts de la ciutat has pogut comptabilitzar al llarg de la visita?",
            "Segons la imatge, on creieu que estava situat l'orgue anterior? Situeu-lo al plànol",
            "Observeu bé la imatge i responeu.",
            "Aneu a la ubicació que mostra el plànol i obriu la informació del codi QR.",
            "Quina és la relació entre el disseny de la façana del nou orgue i la ciutat de Valls?",
            "Aneu a la ubicació que mostra el plànol i obriu la nova informació. Llegiu i relacioneu cada tipus d’orgue amb la definició que creieu que li correspon.",
            "Llegiu i relacioneu cada tipus d’orgue amb la definició que creieu que li correspon.",
            "Ja sabeu força coses sobre aquest instrument. Aneu a la nova ubicació per continuar amb l’activitat.Mireu bé la façana de l’orgue i trieu de totes aquestes parts les que són visibles. barnilles, caixa de l’expressiu, manuals, manxes, pedal de l’expressiu, pedaler, poms dels registres, secret, tubs.",
            "Mireu bé la façana de l’orgue i trieu de totes aquestes parts les que són visibles.",
            "Ja esteu acabant. Aneu a obrir el codi que us donarà, completarà la informació sobre aquest instrument. Quina és la diferència entre orguener i organista?",
            "Quina és la diferència entre orguener i organista?",
            "Heu recordat de comptar els escuts de la ciutat? Ara podeu donar la resposta."
    };

    public static int choices[][] = {
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},

    };

    public static int correctAnswers[] = {
            R.id.bottom_left,
            R.id.bottom_left,
            R.id.middle_right,
            R.id.top_right,
            R.id.bottom_right,
            R.id.top_left,
            R.id.bottom_left,
            R.id.middle_left
    };

    public static int[] images = {
            R.drawable.pregunta1,
            R.drawable.pregunta2,
            R.drawable.pregunta3,
            R.drawable.pregunta4,
            R.drawable.pregunta4,
            R.drawable.pregunta4,
            R.drawable.pregunta4,
            R.drawable.pregunta4,
            R.drawable.pregunta4,
            R.drawable.pregunta4,
            R.drawable.pregunta4,




    };

    public static String[][] info = {
            {"Aquests carreus donen informació de qui i com s’ha pogut  construir aquest edifici.","Els lleons representen la força, el valor i la noblesa i per altra banda veiem l’escut de la ciutat.","La gent de la ciutat s’han preocupat per poder-lo construir i hi ha col·laborat en la mesura que a cadascú li era possible."," "," "},
            {"La ciutat de Valls se sap que ja tenia orgue des de fa molts anys. Quan es va construir aquest edifici ja es va tenir present que n’havia de tenir un i l’any 1590 se sap que ja va sonar per primer cop. L’orgue que podeu veure a la fotografia és el resultat de les restauracions que aquell orgue va anar tenint al llarg dels anys.","Durant 346 anys hi va haver un orgue sonant en aquesta nau fins que el 21 de juliol de l’any 1936, amb la guerra civil, va ser destruït.","Han passat més de 80 anys fins que no s’ha pogut recuperar un orgue per a la ciutat."," "," "},
            {"La recuperació de l’orgue ha estat possible gracies al treball constant durant els últims anys d’una Comissió ciutadana formada per persones que estimen la ciutat i la cultura.","Tal com es va fer amb la construcció de l'edifici s'ha demanat la col·laboració econòmica dels ciutadans per poder  dur a terme aquest projecte. Tota aquesta gent que han fet possible la construcció de l’instrument que avui visitem són els Padrins de l'orgue.","El disseny de la façana està inspirat en elements característics de la ciutat."," "," "},
            {"L’antic orgue estava situat a la meitat de la nau i suspès dalt d’una balconada tal com podeu veure en les imatges. De vegades els orgues estan situats just damunt la porta d’entrada de l’edifici en la zona de l’anomenat cor.","Hi ha diferents tipus d’orgues segons les èpoques, la utilització que se’n feia, els espais on estaven ubicats..."," "," "," "},
            {"L’orgue és un instrument de vent, això vol dir que el so el produeix l’aire quan vibra en passar pels tubs.","Aquest instrument tan gran té unes parts visibles, la façana i la consola, i unes parts que estan a l’interior i que són els mecanismes que fan que l’orgue soni. La consola és el centre de comandament de la persona que toca l’instrument."," "," "," "},
            {"Aquest orgue en l’actualitat consta de 1384 tubs però està preparat per a tenir-ne 2504. Cada tecla té associat, com a mínim,  un tub per a cada un dels registres que es puguin activar.", "Recordeu que la recuperació i construcció ha estat possible gràcies a les donacions de gent particular, empreses de la ciutat i les administracions.", "Hi ha dos tipus de tubs segons la manera de produir el so: els de boca o labials i els de llengüeta.  També  la mida, la forma i els materials dels que estan fets els tubs donen una sonoritat diferent segons el que es requereix per a cada un dels registres", "Si l’organista activa el registre de trompeta sonaran els tubs que estan modelats per a produir aquest tipus de so. Si activa el registre de gralla sonaran els tubs que estan preparats per a fer-ho i així amb tots els sons.", "L’organista també pot combinar diferents registres per a tocar alhora."},
            {"A partir d'ara la Ciutat comptarà amb un intrument ubicat en aquest espai tan gran i que està pensat que tingui diferents usos: Concerts,Aprenentatge i estudi de l'instrument","","",""},
            {""},

    };

    public static String[][] spinnerChoices = {
            {""},
            {"Entre 10 i 20", "Entre 21 i 40", "Més de 40"},
            {""},
            {"Està arran de terra", "Està suspès en una balconada"},
            {""},
            {"Els calçots i els castells", "Els castells i el campanar", "El campanar i els gegants"},
            {""},
            {"EN CONSTRUCCIÓ"},
            {""},
            {""},
            {""},
            {"No hi ha cap diferència, és el mateix.", "L’orguener construeix i l’organista toca.","L’organista construeix i l’orguener toca.","L’orguener toca molt i l’organista no toca gaire."}
    };
}
