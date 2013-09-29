package edu.rug.gogp.patrik.lemmings;

import edu.rug.gogp.patrik.lemmings.model.Field;
import edu.rug.gogp.patrik.lemmings.model.Lemming;
import edu.rug.gogp.patrik.lemmings.view.FieldView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author s2288842
 */
public class Lemmings {

    /**
     * @param args the command line arguments
     */
    private static final String[] CITY_NAMES = {"Aagtekerke", "Aalden", "Aalsmeer", "Aalst", "Aalst Gld", "Aalten", "Aalzum", "Aardenburg", "Aarlanderveen", "Aarle Rixtel", "Aarle-Rixtel", "Abbekerk ", "Abbenbroek", "Abcoude", "Achterberg", "Achthuizen", "Acquoy", "Aerdt", "Afferden", "Afferden Gld", "Afferden Lb", "Agelo", "Akersloot", "Akkrum", "Albergen", "Alblasserdam", "Alblasserdam", "Aldeboarn", "Alkmaar", "Alkmaar", "Alkmaar", "Alkmaar", "Allingawier", "Almelo", "Almelo", "Almelo", "Almelo", "Almen", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almkerk", "Alphen", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen Nb", "Alteveer Gn", "Ambt Delden", "Ameide", "Amen", "America", "Amerongen", "Amersfoort", "Amersfoort", "Amersfoort", "Amstelveen", "Amstelveen", "Amstelveen", "Amstenrade", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam Zuidoost", "Amsterdam Zuidoost", "Andel", "Andelst", "Anderen", "Andijk", "Ane", "Anerveen", "Anjum", "Ankeveen", "Anloo", "Anna Paulowna", "Annen", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Appelscha", "Appeltern", "Appingedam", "Appingedam", "Arcen", "Arkel", "Arnemuiden", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arrien", "Arum", "Asperen", "Assen", "Assen", "Assendelft", "Asten", "Augustinusga", "Austerlitz", "Avenhorn", "Axel", "Azewijn", "Baarland", "Baarle Nassau", "Baarle-Nassau", "Baarlo", "Baarlo Lb", "Baarn", "Baarn", "Babberich", "Badhoevedorp", "Baexem", "Baflo", "Bakel", "Bakhuizen", "Bakkeveen", "Balgoij", "Balk", "Balkbrug", "Balkbrug", "Ballum", "Banholt", "Bant", "Barchem", "Barendrecht", "Barger Compascuum", "Barneveld", "Batenburg", "Bathmen", "Bavel", "Bedum", "Beegden", "Beek", "Beek", "Beek en Donk", "Beek Gem Bergh", "Beek Gem Montferland", "Beekbergen", "Beek-Ubbergen", "Beers Nb", "Beerze", "Beesd", "Beesel", "Beetsterzwaag", "Beilen", "Belfeld", "Bellingwedde", "Bellingwolde", "Belt Schutsloot", "Bemelen", "Bemmel", "Beneden Leeuwen", "Beneden-Leeuwen", "Bennebroek", "Bennekom", "Benningbroek", "Benschop", "Benthuizen", "Berg en Dal", "Berg en Terblijt", "Bergambacht", "Bergeijk", "Bergen", "Bergen (Limburg)", "Bergen Aan Zee", "Bergen L", "Bergen Lb", "Bergen Nh", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergentheim", "Bergh", "Bergharen", "Berghem", "Bergschenhoek", "Berkel en Rodenrijs", "Berkel-Enschot", "Berkhout", "Berlicum", "Berlicum Nb", "Best", "Best", "Beuningen", "Beuningen Gld", "Beuningen Ov", "Beusichem", "Beverwijk", "Beverwijk", "Biddinghuizen", "Bierum", "Biervliet", "Biezenmortel", "Biggekerke", "Bilthoven", "Bladel", "Blaricum", "Bleiswijk", "Bleskensgraaf", "Bleskensgraaf", "Bleskensgraaf Ca", "Blije", "Blijham", "Blitterswijck", "Blokker", "Blokzijl", "Bocholtz", "Bodegraven", "Boekel", "Boekelo", "Boijl", "Bolsward", "Boornzwaag", "Borculo", "Borger", "Born", "Borne", "Bornerbroek", "Borssele", "Boskoop", "Botlek Rotterdam", "Bourtange", "Boven Leeuwen", "Bovenkarspel", "Bovensmilde", "Boxmeer", "Boxtel", "Boxtel", "Braamt", "Brakel", "Brandwijk", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breedenbroek", "Breezand", "Breskens", "Breukelen", "Breukelen Ut", "Brielle", "Broek in Waterland", "Broekhuizenvorst", "Broekland Ov", "Bronnegerveen", "Brouwershaven", "Bruchem", "Bruinehaar", "Bruinisse", "Brummen", "Brunssum", "Brunssum", "Buchten", "Budel", "Budel Dorplein", "Budel-Schoot", "Buinerveen", "Buitenpost", "Bunde", "Bunnik", "Bunschoten", "Bunschoten Spakenburg", "Burdaard", "Buren", "Buren Fr", "Buren Gld", "Burgerbrug", "Burgh-Haamstede", "Burgum", "Bussum", "Bussum", "Cadier en Keer", "Cadzand", "Callantsoog", "Capelle aan den IJssel", "Capelle aan den IJssel", "Capelle aan den IJssel", "Castelre", "Castricum", "Chaam", "Coevorden", "Colijnsplaat", "Collendoorn", "Colmschate", "Cornwerd", "Cothen", "Creil", "Cromvoirt", "Cuijk", "Culemborg", "Culemborg", "Daarle", "Dalen", "Dalerveen", "Dalfsen", "Damwoude", "Darp", "De Beerzen", "De Bilt", "De Bult", "De Cocksdorp", "De Goorn", "De Heen", "De Heurne", "De Kiel", "De Klomp", "De Koog", "De Krim", "De Kwakel", "De Lier", "De Lutte", "De Meern", "De Moer", "De Pol", "De Punt", "De Rips", "De Schiphorst", "De Steeg", "De Valom", "De Waal", "De Wijk", "De Woude", "Dearsum", "Dedemsvaart", "Dedgum", "Deest", "Delden", "Delfgauw", "Delfstrahuizen", "Delft", "Delft", "Delfzijl", "Den Andel", "Den Bommel", "Den Bosch", "Den Burg", "Den Dolder", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Ham", "Den Ham Ov", "Den Helder", "Den Helder", "Den Helder", "Den Helder", "Den Hoorn Texel", "Den Hoorn Zh", "Den Hout", "Den Hout Nb", "Den Ilp", "Den Oever", "Denekamp", "Deurne", "Deurningen", "Deventer", "Deventer", "Deventer", "Didam", "Didam", "Diemen", "Diepenheim", "Diepenveen", "Dieren", "Diessen", "Diever", "Dieverbrug", "Diffelen", "Dinteloord", "Dinxperlo", "Dirkshorn", "Dirksland", "Dodewaard", "Doenrade", "Doesburg", "Doesburg", "Doetinchem", "Doetinchem", "Doetinchem", "Doetinchem", "Doezum", "Dokkum", "Doldersum", "Domburg", "Dongen", "Dongen", "Dongen", "Donkerbroek", "Doorn", "Doornenburg", "Doornspijk", "Doorwerth", "Dordrecht", "Dordrecht", "Dordrecht", "Dorst", "Drachten", "Drachten", "Dreischor", "Drempt", "Dreumel", "Driebergen", "Driebergen-Rijsenburg", "Driebruggen", "Driemond", "Driesum", "Drijber", "Drimmelen", "Drogeham", "Dronrijp", "Dronten", "Drouwen", "Drunen", "Druten", "Duiven", "Duivendrecht", "Duivendrecht", "Dussen", "Dwingeloo", "Earnewald", "Echt", "Echt", "Echteld", "Echten", "Echten Dr", "Eck en Wiel", "Eckelrade", "Edam", "Ede", "Ede", "Ede", "Ederveen", "Ee", "Eede", "Eefde", "Eelde", "Eelderwolde", "Eemnes", "Eemshaven", "Een", "Een West", "Eerbeek", "Eersel", "Ees", "Eesveen", "Eext", "Egchel", "Egmond aan de Hoef", "Egmond aan den Hoef", "Egmond aan Zee", "Egmond binnen", "Egmond-Binnen", "Eibergen", "Eijsden", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Einighausen", "Elburg", "Elim", "Ellemeet", "Elp", "Elsendorp", "Elshout", "Elsloo", "Elsloo Fr", "Elsloo Lb", "Elspeet", "Elst", "Elst", "Elst Gld", "Emmeloord", "Emmeloord", "Emmeloord", "Emmen", "Emmen", "Emmen", "Emmen", "Emmer Compascuum", "Emmer-Compascuüm", "Empe", "Emst", "Engwierum", "Enkhuizen", "Ens", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enspijk", "Enter", "Epe", "Epen", "Epse", "Erica", "Erm", "Ermelo", "Ermelo", "Erp", "Esbeek", "Etten", "Etten Gld", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Europoort Rotterdam", "Eursinge", "Exloo", "Eys", "Farmsum", "Ferwerd", "Ferwert", "Fijnaart", "Finsterwolde", "Fochteloo", "Follega", "Foxhol", "Franeker", "Frederiksoord", "Froombosch", "Gaastmeer", "Gameren", "Gapinge", "Garderen", "Garyp", "Gasselte", "Gasselternijv. Mond", "Gasselternijveen", "Geersdijk", "Geertruidenberg", "Gees", "Geesbrug", "Geesteren", "Geesteren Gld", "Geesteren Ov", "Geeuwenbrug", "Geffen", "Geijsteren", "Geldermalsen", "Geldrop", "Geldrop", "Geldrop", "Geldrop-Mierlo", "Geleen", "Geleen", "Geleen", "Gemert", "Genderen", "Gendringen", "Gendt", "Genemuiden", "Gennep", "Gerkesklooster", "Gersloot", "Giekerk", "Giesbeek", "Giessen", "Giessenburg", "Giessendam", "Gieten", "Gieterveen", "Giethmen", "Giethoorn", "Gilze", "Ginnum", "Glane", "Glanerbrug", "Goedereede", "Goes", "Goirle", "Goor", "Gorinchem", "Gorinchem", "Gorinchem", "Gorredijk", "Gorssel", "Gouda", "Gouda", "Gouda", "Gouderak", "Goudriaan", "Goudswaard", "Graft", "Graft-De Rijp", "Gramsbergen", "Grashoek", "Grathem", "Grave", "Gravendeel", "Gravenzande", "Grijpskerk", "Groede", "Groenekan", "Groenlo", "Groesbeek", "Groet", "Grolloo", "Groningen", "Groningen", "Groningen", "Groningen", "Groningen", "Gronsveld", "Groot Ammers", "Grootebroek", "Grootegast", "Grou", "Grubbenvorst", "Gulpen", "Gytsjerk", "Haaften", "Haaksbergen", "Haamstede", "Haaren", "Haarle Gem Hellend.", "Haarle Gem Tubbergen", "Haarlem", "Haarlem", "Haarlem", "Haarlo", "Haarzuilens", "Haastrecht", "Haelen", "Hagestein", "Haghorst", "Halfweg", "Halfweg Nh", "Hall", "Halle", "Hallum", "Halsteren", "Handel", "Hank", "Hantumeruitburen", "Hapert", "Haps", "Harbrinkhoek", "Hardenberg", "Harderwijk", "Harderwijk", "Harderwijk", "Hardinxveld", "Hardinxveld Giessendam", "Hardinxveld-Giessendam", "Haren", "Harfsen", "Harich", "Harkstede", "Harlingen", "Harmelen", "Harskamp", "Haskerhorne", "Hasselt", "Hattem", "Hattemerbroek", "Haule", "Haulerwijk", "Havelte", "Hazerswoude Dorp", "Hazerswoude Rijndijk", "Hazerswoude-Dorp", "Hazerswoude-Rijndijk", "Hedel", "Heeg", "Heemserveen", "Heemskerk", "Heemskerk", "Heemskerk", "Heemstede", "Heemstede", "Heenvliet", "Heerde", "Heerenveen", "Heerenveen", "Heerenveen", "Heerhugowaard", "Heerhugowaard", "Heerjansdam", "Heerle", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heesch", "Heeswijk Dinther", "Heeten", "Heeze", "Hei en Boeicop", "Heide", "Heijen", "Heijenrath", "Heijningen", "Heiloo", "Heinenoord", "Heinkenszand", "Heino", "Helden", "Hellendoorn", "Hellevoetsluis", "Hellevoetsluis", "Helmond", "Helmond", "Helmond", "Helvoirt", "Hemelum", "Hempens", "Hemrik", "Hendrik Ido Ambacht", "Hendrik-Ido-Ambacht", "Hengelo", "Hengelo (G)", "Hengelo GL", "Hengelo Gld", "Hengelo Ov", "Hengelo Ov", "Hengelo Ov", "Hengstdijk", "Herkenbosch", "Herkingen", "Herpen", "Herten", "Hertme", "Herwen", "Herwijnen", "Heteren", "Heukelom Nb", "Heusden", "Heusden Gem Asten", "Heythuysen", "Hezingen", "Hiaure", "Hierden", "Hieslum", "Hijken", "Hilaard", "Hillegom", "Hilvarenbeek", "Hilversum", "Hilversum", "Hilversum", "Hindeloopen", "Hippolytushoef", "Hoek", "Hoek van Holland", "Hoenderloo", "Hoensbroek", "Hoevelaken", "Hoeven", "Hof van Twente", "Hoge Hexel", "Hollandsche Rading", "Hollandscheveld", "Hollum", "Holsloot", "Holten", "Holtheme", "Holwerd", "Holwierde", "Hommerts", "Honselersdijk", "Hoofddorp", "Hoofddorp", "Hooge Mierde", "Hoogeloon", "Hoogerheide", "Hoogersmilde", "Hoogeveen", "Hoogeveen", "Hoogeveen", "Hoogezand", "Hoogezand", "Hoogezand-Sappemeer", "Hooghalen", "Hoogkarspel", "Hoogland", "Hoog-Soeren", "Hoogvliet", "Hoogvliet Rotterdam", "Hoogwoud", "Hoorn", "Hoorn", "Hoorn Nh", "Hoorn Nh", "Hoornaar", "Horst", "Houten", "Houten", "Huijbergen", "Huis Ter Heide Dr", "Huis Ter Heide Ut", "Huisseling", "Huissen", "Huizen", "Huizen", "Hulsberg", "Hulsel", "Hulshorst", "Hulst", "Hummelo", "Hunsel", "Hurdegaryp", "Idsegahuizum", "Idzega", "IJhorst", "IJlst", "Ijmuiden", "Ijmuiden", "Ijmuiden", "Ijsselmuiden", "IJsselstein Ut", "IJzendijke", "Ilpendam", "Ingen", "It Heidenskip", "Ittervoort", "Jannum", "Jirnsum", "Jislum", "Jisp", "Jistrum", "Jonkersvaart", "Joure", "Jubbega", "Julianadorp", "Kaag", "Kaatsheuvel", "Kalenberg", "Kallenkote", "Kamerik", "Kampen", "Kampen", "Kampen", "Kampen-c", "Kamperland", "Kapel Avezaath Buren", "Kapelle", "Kats", "Kattendijke", "Katwijk", "Katwijk Nb", "Katwijk Zh", "Kelpen-Oler", "Kerkdriel", "Kerkrade", "Kerkrade", "Kerkrade", "Kerkwerve", "Kessel", "Kessel Lb", "Kesteren", "Kiel Windeweer", "Kimswerd", "Klaaswaal", "Klarenbeek", "Klazienaveen", "Kleine Sluis", "Klijndijk", "Klimmen", "Klooster Lidlum", "Kloosterburen", "Kloosterzande", "Klundert", "Kockengen", "Koekange", "Koewacht", "Kolham", "Kolhorn", "Kollum", "Kollum", "Kollumerpomp", "Kollumerzwaag", "Koningsbosch", "Koningslust", "Koog aan de Zaan", "Kootstertille", "Kootwijk", "Kootwijkerbroek", "Kornhorn", "Kortehemmen", "Kortenhoef", "Kortgene", "Koudekerk aan den Rijn", "Koudekerke", "Koudum", "Krabbendijke", "Kraggenburg", "Krimpen aan den IJssel", "Krimpen aan de Lek", "Krimpen aan den IJssel", "Kring van Dorth", "Krommenie", "Kronenberg", "Kruiningen", "Kruisland", "Kuinre", "Kwadijk", "Laag Soeren", "Lage Mierde", "Lage Zwaluwe", "Lageland", "Lambertschaag", "Lamswaarde", "Landgraaf", "Landgraaf", "Landsmeer", "Langbroek", "Langelille", "Langenboom", "Langerak", "Langeveen", "Langeweg", "Langweer", "Laren", "Laren Gld", "Lathum", "Lattrop Breklenkamp", "Lauwersoog", "Lauwerzijl", "Ledeacker", "Leek", "Leende", "Leens", "Leerdam", "Leersum", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leiden", "Leiden", "Leiden", "Leiderdorp", "Leidschendam", "Leidschendam", "Leimuiden", "Lekkerkerk", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lemele", "Lemelerveld", "Lemiers", "Lemmer", "Lent", "Lettele", "Leusden", "Leusden", "Lewedorp", "Lexmond", "Lichtenvoorde", "Liempde", "Lienden", "Lieren", "Lierop", "Lieshout", "Liessel", "Lievelde", "Lijnden", "Limmen", "Linden", "Linschoten", "Lisse", "Lisserbroek", "Lith", "Lobith", "Lochem", "Loenen", "Loenen aan de Vecht", "Loenen Gld", "Loenga", "Lomm", "Loon op Zand", "Loosdrecht", "Loozen", "Lopik", "Lopikerkapel", "Loppersum", "Losser", "Lottum", "Luchthaven Schiphol", "Lunteren", "Lutjewinkel", "Luttelgeest", "Luttenberg", "Luyksgestel", "Maarheeze", "Maarn", "Maarsbergen", "Maarssen", "Maarssen", "Maarssen", "Maarssenbroek", "Maartensdijk", "Maasbommel", "Maasbracht", "Maasbree", "Maasdam", "Maasdijk", "Maashees", "Maasland", "Maassluis", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maasvlakte Rotterdam", "Made", "Makkum", "Makkum Fr", "Malden", "Mander", "Mantgum", "Margraten", "Maria Hoop", "Mariahout", "Mariaparochie", "Marienberg", "Mariónberg", "Markelo", "Marken", "Marknesse", "Marrum", "Marssum", "Marum", "Marwijksoord", "Matsloot", "Maurik", "Mechelen", "Medemblik", "Meedhuizen", "Meerkerk", "Meerlo", "Meerssen", "Megchelen", "Megen", "Meijel", "Melderslo", "Melick", "Melissant", "Menaldum", "Meppel", "Meppel", "Meppen", "Merselo", "Meterik", "Mheer", "Middelaar", "Middelburg", "Middelburg", "Middelburg", "Middelharnis", "Middelstum", "Middenbeemster", "Middenmeer", "Midlaren", "Midlum", "Midwolda", "Midwolde", "Midwoud", "Mierlo", "Mijdrecht", "Mijnsheerenland", "Milheeze", "Mill", "Millingen aan de Rijn", "Milsbeek", "Moerdijk", "Moergestel", "Moerkapelle", "Moerstraten", "Molenhoek Lb", "Molenschot", "Molkwerum", "Monnickendam", "Monster", "Montfoort", "Montfort", "Mook", "Mookhoek", "Moordrecht", "Morra", "Muiden", "Muiderberg", "Muntendam", "Mussel", "Musselkanaal", "Naaldwijk", "Naarden", "Nagele", "Nederhemert", "Nederhorst den Berg", "Nederweert", "Nederweert Eind", "Neede", "Neer", "Neerijnen", "Neerkant", "Nes", "Nes Ameland", "Nes Gem Dongeradeel", "Netersel", "Netterden", "Nibbixwoud", "Niebert", "Niedorp", "Niekerk Grootegast", "Nietap", "Nieuw Amsterdam", "Nieuw Balinge", "Nieuw Beijerland", "Nieuw Buinen", "Nieuw Dordrecht", "Nieuw Heeten", "Nieuw Lekkerland", "Nieuw Roden", "Nieuw Vennep", "Nieuw Vennep", "Nieuw Vossemeer", "Nieuw Weerdinge", "Nieuw-Beijerland", "Nieuwdorp", "Nieuwe Niedorp", "Nieuwe Pekela", "Nieuwe Tonge", "Nieuwegein", "Nieuwegein", "Nieuwegein", "Nieuwehorne", "Nieuwendijk Nb", "Nieuwer ter Aa", "Nieuwerbrug", "Nieuwerkerk", "Nieuwerkerk aan den IJssel", "Nieuweroord", "Nieuweschans", "Nieuwkoop", "Nieuwkuijk", "Nieuwland", "Nieuw-Lekkerland", "Nieuwleusen", "Nieuw-Namen", "Nieuwolda", "Nieuwveen", "Nieuw-Vennep", "Nieuwvliet", "Nieuw-Vossemeer", "Nigtevecht", "Nij Beets", "Nijehaske", "Nijemirdum", "Nijensleek", "Nijeveen", "Nijhuizum", "Nijkerk", "Nijkerk Gld", "Nijkerkerveen", "Nijland", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijswiller", "Nijverdal", "Nijverdal", "Nispen", "Nistelrode", "Nooitgedacht", "Noorbeek", "Noord Sleen", "Noordbroek", "Noorden", "Noordhorn", "Noord-Scharwoude", "Noordscheschut", "Noordwelle", "Noordwijk", "Noordwijk", "Noordwijk Gn", "Noordwijk Zh", "Noordwijk Zh", "Noordwijkerhout", "Noordwolde", "Norg", "Nuenen", "Nuenen", "Nuland", "Numansdorp", "Nunspeet", "Nuth", "Nutter", "Obdam", "Ochten", "Odijk", "Odiliapeel", "Odoorn", "Odoornerveen", "Oeffelt", "Oegstgeest", "Oene", "Offingawier", "Oh en Laak", "Oirlo", "Oirsbeek", "Oirschot", "Oisterwijk", "Oldeberkoop", "Oldebroek", "Oldeholtwolde", "Oldehove", "Oldemarkt", "Oldenzaal", "Oldenzaal", "Oldenzaal", "Oldeouwer", "Olst", "Olst-Wijhe", "Ommel", "Ommen", "Ommeren", "Onnen", "Onstwedde", "Ooltgensplaat", "Oost W en Middelbeers", "Oostburg", "Oosterbeek", "Oosterend Nh", "Oosterhesselen", "Oosterhout", "Oosterhout", "Oosterhout (Nijmegen)", "Oosterhout GLD", "Oosterhout Nb", "Oosterhout Nb", "Oosterland", "Oosternijkerk", "Oosterstreek", "Oosterwolde", "Oosthuizen", "Oostkapelle", "Oostknollendam", "Oostrum Fr", "Oostvoorne", "Oostwold Scheemda", "Oostwoud", "Oostzaan", "Ootmarsum", "Opeinde", "Opende", "Ophemert", "Opheusden", "Oploo", "Opmeer", "Opperdoes", "Orvelte", "Ospel", "Oss", "Oss", "Oss", "Ossendrecht", "Ossenisse", "Ossenzijl", "Oterleek", "Otterlo", "Ottoland", "Oud Ade", "Oud Beijerland", "Oud Beijerland", "Oud Gastel", "Oud Ootmarsum", "Oud-Alblas", "Oud-Beijerland", "Ouddorp", "Ouddorp Zh", "Oude Meer", "Oude Pekela", "Oude Tonge", "Oude Willem", "Oudega Gaast Sleat", "Oudega Gem Small.", "Oudega Gem Wymbr.", "Oudemirdum", "Oudenbosch", "Oudenhoorn", "Ouderkerk a/d Amstel", "Ouderkerk aan de Amstel", "Ouderkerk aan den Amstel", "Ouderkerk aan den IJssel", "Oudeschild", "Oudeschoot", "Oudesluis", "Oude-Tonge", "Oudewater", "Oud-Gastel", "Oudorp", "Oudwoude", "Ouwerkerk", "Overasselt", "Overberg", "Overdinkel", "Overloon", "Overveen", "Ovezande", "Paasloo", "Pannerden", "Panningen", "Papendrecht", "Papendrecht", "Papenvoort", "Parrega", "Paterswolde", "Peize", "Pesse", "Petten", "Piershil", "Pieterburen", "Pijnacker", "Pingjum", "Plasmolen", "Poeldijk", "Poortugaal", "Poortvliet", "Posterholt", "Prinsenbeek", "Purmerend", "Purmerend", "Purmerend", "Putte", "Putten", "Puttershoek", "Raalte", "Raalte", "Raamsdonksveer", "Raard", "Radewijk", "Randwijk", "Ransdaal", "Ransdorp", "Ravenstein", "Reahus", "Reek", "Reeuwijk", "Reijmerstok", "Rekken", "Renesse", "Renkum", "Renswoude", "Retranchement", "Reusel", "Reutum", "Reuver", "Rheden", "Rhee", "Rheeze", "Rheezerveen", "Rhenen", "Ridderkerk", "Ridderkerk", "Ridderkerk", "Riel", "Riethoven", "Rietmolen", "Rijen", "Rijkevoort", "Rijnsburg", "Rijpwetering", "Rijs", "Rijsbergen", "Rijsenhout", "Rijssen", "Rijswijk", "Rijswijk Zh", "Rijswijk Zh", "Rilland", "Rinsumageest", "Ritthem", "Ritthem", "Rockanje", "Roden", "Roelofarendsveen", "Roermond", "Roermond", "Rogat", "Roggel", "Rohel", "rolde", "Roodeschool", "Roosendaal", "Roosendaal", "Roosendaal", "Roosteren", "Rosmalen", "Rossum", "Rossum Ov", "Roswinkel", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rouveen", "Rozenburg", "Rozenburg Nh", "Rozenburg Zh", "Rozendaal", "Rucphen", "Ruigahuizen", "Ruinen", "Ruinerwold", "Rumpt", "Rutten", "Ruurlo", "Rykevoort-De Walsert", "Saaksum", "Saasveld", "Sandfirden", "Sappemeer", "Sas van Gent", "Sassenheim", "Schagen", "Schagerbrug", "Schaijk", "Schalkhaar", "Schalkwijk", "Schardam", "Scharendijke", "Scharmer", "Scharsterbrug", "Scheemda", "Scheerwolde", "Schellinkhout", "Schelluinen", "Scherpenisse", "Scherpenzeel", "Scherpenzeel FR", "Scherpenzeel Gld", "Schiedam", "Schiedam", "Schiedam", "Schiermonnikoog", "Schijf", "Schijndel", "Schildwolde", "Schin op Geul", "Schinnen", "Schinveld", "Schipborg", "Schiphol", "Schiphol-Rijk", "Schipluiden", "Schoondijke", "Schoonebeek", "Schoonhoven", "Schoonloo", "Schoonoord", "Schoonrewoerd", "Schoorl", "Sellingen", "Serooskerke", "Sevenum", "Sexbierum", "'S-Gravendeel", "s-Gravenmoer", "s-Gravenpolder", "s-Gravenzande", "'S-Gravenzande", "s-Heer Arendskerke", "'S-Heerenberg", "'S-Heerenbroek", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "Sibculo", "Siddeburen", "Siebengewald", "Siegerswoude", "Sijbekarspel", "Silvolde", "Simpelveld", "Sinderen", "Sint Agatha", "Sint Annaland", "Sint Annaparochie", "Sint Anthonis", "Sint Geertruid", "Sint Hubert", "Sint Jacobiparochie", "Sint Jansklooster", "Sint Maarten", "Sint Maartensbrug", "Sint Maartensdijk", "Sint Maartensvlotbrug", "Sint Nicolaasga", "Sint Odiliënberg", "Sint Odiliónberg", "Sint Philipsland", "Sint-Annaland", "Sint-Kruis", "Sint-Maartensdijk", "Sint-Michielsgestel", "Sint-Oedenrode", "Sirjansland", "Sittard", "Sittard", "Slagharen", "Sleen", "Sleeuwijk", "Sliedrecht", "Slijk Ewijk", "Slochteren", "Slootdorp", "Sloten", "Sluis", "Sluiskil", "Smakt", "Smilde", "Sneek", "Sneek", "Snelrewaard", "Soerendonk", "Soest", "Soest", "Soesterberg", "Someren", "Sommelsdijk", "Son", "Sondel", "Spaarndam", "Spanbroek", "Spier", "Spijk Gn", "Spijkenisse", "Spijkenisse", "Spijkerboor", "Sprang-Capelle", "Sprundel", "Stad aan 't Haringvliet", "Stadskanaal", "Stadskanaal", "Stamproy", "Standdaarbuiten", "Staphorst", "Stavenisse", "Stavoren", "Steenbergen", "Steenbergen Dr", "Steenbergen Nb", "Steendam", "Steenderen", "Steenwijk", "Stegeren", "Steggerda", "Stein", "Stein Lb", "Stellendam", "Sterksel", "Stevensbeek", "Stevensweert", "Stieltjeskanaal", "Stiens", "Stokkum", "Stolwijk", "Stompetoren", "Stramproy", "Strijbeek", "Strijen", "Stroe", "Stroobos", "Stuifzand", "Sumar", "Surhuisterveen", "Susteren", "Swalmen", "Swifterbant", "Swolgen", "'T Goy", "t Harde", "'T Harde", "'T Loo Oldebroek", "'T Zand Nh", "Tegelen", "Ten Boer", "Ten Post", "Ter Aar", "Ter Apel", "Terborg", "Terheijden", "Terherne", "Terkaple", "Termunterzijl", "Ternaard", "Terneuzen", "Teroele", "Terschelling Formerum", "Terschelling Hee", "Terschelling Hoorn", "Terschelling Kinnum", "Terschelling Landerum", "Terschelling Lies", "Terschelling Midsland", "Terschelling O.End", "Terschelling West", "Terschuur", "Terwolde", "Teteringen", "Teuge", "Tholen", "Thorn", "Tiel", "Tiel", "Tiel", "Tiendeveen", "Tienhoven Ut", "Tienray", "Tijnje", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tinte", "Tolkamer", "Triemen", "Tripscompagnie", "Tubbergen", "Tuitjenhorn", "Tull en 'T Waal", "Tweede Exloermond", "Tweede Exloërmond", "Twello", "Twijzel", "Twisk", "Tynaarlo", "Tytsjerk", "Tzum", "Tzummarum", "Uddel", "Uden", "Uden", "Udenhout", "Uffelte", "Ugchelen", "Uitdam", "Uitgeest", "Uithoorn", "Uithoorn", "Uithuizen", "Uithuizermeeden", "Uitwellingerga", "Ulestraten", "Ulft", "Ulicoten", "Ulrum", "Ulvenhout", "Ureterp", "Urk", "Ursem", "Usquert", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Vaals", "Vaassen", "Valburg", "Valkenburg", "Valkenburg aan de Geul", "Valkenburg Lb", "Valkenburg Zh", "Valkenswaard", "Valkenswaard", "Valthermond", "Varik", "Varsseveld", "Vasse", "Veen", "Veendam", "Veendam", "Veenendaal", "Veenendaal", "Veenhuizen", "Veenoord", "Veenwouden", "Veere", "Veessen", "Vegelinsoord", "Veghel", "Veghel", "Veghel", "Veghel", "Velddriel", "Velden", "Veldhoven", "Veldhoven", "Veldhoven", "Velp", "Velp Gld", "Velp Nb", "Velsen", "Velsen-Noord", "Velsen-Zuid", "Venhorst", "Venhuizen", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venray", "Vessem", "Vianen", "Vianen Ut", "Vierakker", "Vierhouten", "Vierhuizen", "Vierlingsbeek", "Vierpolders", "Vijfhuizen", "Vijlen", "Vilsteren", "Vinkega", "Vinkeveen", "Visvliet", "Vlaardingen", "Vlaardingen", "Vlagtwedde", "Vledder", "Vledderveen Dr", "Vleuten", "Vlieland", "Vlierden", "Vlijmen", "Vlissingen", "Vlissingen", "Vlodrop", "Voerendaal", "Vogelenzang", "Vogelwaarde", "Volendam", "Volendam", "Volkel", "Vollenhove", "Vondelingenplaat Rt", "Voorburg", "Voorhout", "Voorschoten", "Voorst", "Voorst Gem Voorst", "Voorthuizen", "Vorden", "Vragender", "Vredepeel", "Vreeland", "Vries", "Vriescheloo", "Vriezenveen", "Vroomshoop", "Vrouwenparochie", "Vrouwenpolder", "Vught", "Vught", "Vuren", "Waalre", "Waalre", "Waalwijk", "Waalwijk", "Waardenburg", "Waarland", "Waddinxveen", "Wagenborgen", "Wageningen", "Wageningen", "Walem", "Walsoorden", "Wanneperveen", "Wanroij", "Wanssum", "Wapenveld", "Wapse", "Wapserveen", "Warder", "Warffum", "Warfhuizen", "Warfstermolen", "Warmenhuizen", "Warmond", "Warns", "Warnsveld", "Warten", "Waskemeer", "Waspik", "Wassenaar", "Wassenaar", "Wateren", "Watergang", "Wateringen", "Waverveen", "Wedde", "Weerselo", "Weert", "Weert", "Weert", "Weesp", "Wehe Den Hoorn", "Wehl", "Weidum", "Wekerom", "Well Lb", "Wellerlooi", "Welsum", "Wemeldinge", "Wenum Wiesel", "Werkendam", "Werkhoven", "Wernhout", "Wervershoof", "Wervershoof", "Wesepe", "Wessem", "Westbeemster", "Westbroek", "Westdorpe", "Westendorp", "Westerbork", "Westerbroek", "Westergeest", "Westerhaar-Vriezenv W", "Westerhaar-Vriezenv Wijk", "Westerhoven", "Westerland", "Westerlee Gn", "Westernieland", "Westervoort", "Westhoek", "Westkapelle", "Westland", "Westmaas", "West-Terschelling", "Westvoorne", "Westwoud", "Wetering", "Wetzens", "Weurt", "Wezep", "Wezuperbrug", "Wichmond", "Wierden", "Wieringermeer", "Wieringerwaard", "Wieringerwerf", "Wijchen", "Wijckel", "Wijdenes", "Wijhe", "Wijk Aan Zee", "Wijk bij Duurstede", "Wijk en Aalburg", "Wijlre", "Wijnaldum", "Wijngaarden Zh", "Wijnjewoude", "Wijster", "Wilbertoord", "Wildervank", "Wilhelminadorp", "Willemstad", "Willemstad Nb", "Wilnis", "Wilp", "Windraak", "Winkel", "Winschoten", "Winschoten", "Winschoten", "Winssen", "Winsum", "Winsum Gn", "Wintelre", "Winterswijk", "Winterswijk", "Winterswijk Henxel", "Winterswijk Huppel", "Winterswijk Kotten", "Winterswijk Meddo", "Winterswijk Miste", "Winterswijk Woold", "Wissenkerke", "Witmarsum", "Witte Paarden", "Wittelte", "Witteveen", "Woensdrecht", "Woerden", "Woerden", "Woerden", "Woerden", "Woerdense Verlaat", "Wognum", "Woldendorp", "Wolfheze", "Wolphaartsdijk", "Wolsum", "Wolvega", "Wommels", "Workum", "Workum", "Wormer", "Wormerveer", "Woubrugge", "Woudenberg", "Woudrichem", "Wouterswoude", "Wouw", "Wouwse Plantage", "Yerseke", "Ysselsteyn L", "Ysselsteyn Lb", "Zaamslag", "Zaandam", "Zaandam", "Zaandam", "Zaandam", "Zaandijk", "Zalk", "Zaltbommel", "Zandhuizen", "Zandpol", "Zandvoort", "Zeddam", "Zeegse", "Zeeland", "Zeerijp", "Zeewolde", "Zeewolde", "Zeewolde", "Zegge", "Zegveld", "Zeist", "Zeist", "Zeist", "Zelhem", "Zetten", "Zevenaar", "Zevenaar", "Zevenbergen", "Zevenbergen", "Zevenhuizen", "Zevenhuizen Zh", "Zierikzee", "Zijdewind", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoeterwoude", "Zonnemaire", "Zorgvlied", "Zoutelande", "Zoutkamp", "Zuid-Beijerland", "Zuidbroek", "Zuiddorpe", "Zuidhorn", "Zuidlaarderveen", "Zuidland", "Zuidlaren", "Zuidoostbeemster", "Zuid-Scharwoude", "Zuidwolde", "Zuidwolde Dr", "Zuidwolde Gn", "Zuilichem", "Zuna", "Zundert", "Zundert", "Zutphen", "Zutphen", "Zutphen", "Zwaag", "Zwaagdijk", "Zwaagwesteinde", "Zwammerdam", "Zwanenburg", "Zwartebroek", "Zwartemeer", "Zwartewaal", "Zwartewaterland", "Zwartsluis", "Zweeloo", "Zwiggelte", "Zwijndrecht"};
    private static ArrayList<Field> fields = new ArrayList<>();
    private static final int FIELDS_AMOUNT = 10;

    public static void main(String[] args) {
        generateFields();
        generateFieldMaps();
        generateLemmings(4);
    }

    public static void generateFields() {
        for (int i = 0; i < FIELDS_AMOUNT; i++) {
            try {
                Field f = new Field(25565 + i, CITY_NAMES[i]);
                Thread t = new Thread(f);
                t.start();
//onpractisch   
                FieldView fv = new FieldView(f);
                fv.setVisible(true);
                f.dummy2();
                fields.add(f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void generateFieldMaps(){
        Random random = new Random();
        for (Field field : fields) {
            for (int i = 0; i < random.nextInt(FIELDS_AMOUNT/2); i++) {
                Field mapField = fields.get(random.nextInt(FIELDS_AMOUNT));
                if(!mapField.equals(field)){
                    field.addServer(mapField.getFieldAddress());
                }else{
                    i--;
                }
            }
        }
    }
    
    public static FieldView getFieldView(String fieldName) {
        for (Field field : fields) {
            if (field.getFieldName().equals(fieldName)) {
                return (new FieldView(field));
            }
        }
        return null;
    }

    private static void generateLemmings(int amount) {
        Random random = new Random();
        ArrayList
        Field birthField = fields.get(random.nextInt(FIELDS_AMOUNT));
        for (int i = 0; i < amount; i++) {
            Lemming newLemming = new Lemming(birthField);
            int counter = birthField.getCounter();
            newLemming.initLemmingNo(counter);
            birthField.incCounter();
            birthField.addLemming(newLemming); //TODO change so that initializeLemmings is executed
        }
        
    }
}
