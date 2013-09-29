package edu.rug.gogp.patrik.lemmings;

import edu.rug.gogp.patrik.lemmings.model.Lemming;
import edu.rug.gogp.patrik.lemmings.model.Field;
import edu.rug.gogp.patrik.lemmings.view.FieldView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s2288842
 */
public class Lemmings {

    /**
     * @param args the command line arguments
     */
    public static final String[] CITY_NAMES = {"Aagtekerke", "Aalden", "Aalsmeer", "Aalsmeer", "Aalst", "Aalst Gld", "Aalten", "Aalten", "Aalzum", "Aardenburg", "Aarlanderveen", "Aarle Rixtel", "Aarle-Rixtel", "Abbekerk ", "Abbenbroek", "Abcoude", "Achterberg", "Achthuizen", "Acquoy", "Aerdt", "Afferden", "Afferden Gld", "Afferden Lb", "Agelo", "Akersloot", "Akkrum", "Albergen", "Alblasserdam", "Alblasserdam", "Alblasserdam", "Aldeboarn", "Alkmaar", "Alkmaar", "Alkmaar", "Alkmaar", "Alkmaar", "Alkmaar", "Alkmaar", "Allingawier", "Almelo", "Almelo", "Almelo", "Almelo", "Almelo", "Almelo", "Almelo", "Almen", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almere", "Almkerk", "Alphen", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen aan den Rijn", "Alphen Nb", "Alteveer Gn", "Ambt Delden", "Ameide", "Amen", "America", "Amerongen", "Amersfoort", "Amersfoort", "Amersfoort", "Amersfoort", "Amersfoort", "Amstelveen", "Amstelveen", "Amstelveen", "Amstelveen", "Amstelveen", "Amstelveen", "Amstenrade", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam", "Amsterdam Zuidoost", "Amsterdam Zuidoost", "Amsterdam Zuidoost", "Amsterdam Zuidoost", "Andel", "Andelst", "Anderen", "Andijk", "Andijk", "Ane", "Anerveen", "Anjum", "Ankeveen", "Anloo", "Anna Paulowna", "Annen", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Apeldoorn", "Appelscha", "Appeltern", "Appingedam", "Appingedam", "Appingedam", "Arcen", "Arkel", "Arnemuiden", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arnhem", "Arrien", "Arum", "Asperen", "Assen", "Assen", "Assen", "Assen", "Assendelft", "Asten", "Augustinusga", "Austerlitz", "Avenhorn", "Axel", "Azewijn", "Baarland", "Baarle Nassau", "Baarle-Nassau", "Baarlo", "Baarlo Lb", "Baarn", "Baarn", "Baarn", "Babberich", "Badhoevedorp", "Baexem", "Baflo", "Bakel", "Bakhuizen", "Bakhuizen", "Bakkeveen", "Balgoij", "Balk", "Balk", "Balkbrug", "Balkbrug", "Balkbrug", "Ballum", "Banholt", "Bant", "Barchem", "Barendrecht", "Barendrecht", "Barger Compascuum", "Barger Compascuum", "Barneveld", "Batenburg", "Bathmen", "Bavel", "Bedum", "Bedum", "Beegden", "Beek", "Beek", "Beek", "Beek en Donk", "Beek Gem Bergh", "Beek Gem Montferland", "Beekbergen", "Beek-Ubbergen", "Beers Nb", "Beerze", "Beesd", "Beesel", "Beetsterzwaag", "Beetsterzwaag", "Beilen", "Belfeld", "Bellingwedde", "Bellingwolde", "Belt Schutsloot", "Bemelen", "Bemmel", "Beneden Leeuwen", "Beneden-Leeuwen", "Bennebroek", "Bennekom", "Benningbroek", "Benschop", "Benthuizen", "Berg en Dal", "Berg en Dal", "Berg en Terblijt", "Bergambacht", "Bergambacht", "Bergeijk", "Bergen", "Bergen (Limburg)", "Bergen Aan Zee", "Bergen L", "Bergen Lb", "Bergen Nh", "Bergen Nh", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergen op Zoom", "Bergentheim", "Bergentheim", "Bergh", "Bergharen", "Berghem", "Bergschenhoek", "Berkel en Rodenrijs", "Berkel-Enschot", "Berkhout", "Berlicum", "Berlicum Nb", "Best", "Best", "Best", "Best", "Beuningen", "Beuningen Gld", "Beuningen Ov", "Beusichem", "Beverwijk", "Beverwijk", "Beverwijk", "Beverwijk", "Biddinghuizen", "Bierum", "Biervliet", "Biezenmortel", "Biezenmortel", "Biggekerke", "Bilthoven", "Bilthoven", "Bladel", "Blaricum", "Bleiswijk", "Bleskensgraaf", "Bleskensgraaf", "Bleskensgraaf", "Bleskensgraaf Ca", "Blije", "Blijham", "Blitterswijck", "Blokker", "Blokker", "Blokzijl", "Bocholtz", "Bodegraven", "Bodegraven", "Boekel", "Boekelo", "Boijl", "Bolsward", "Boornzwaag", "Borculo", "Borger", "Born", "Borne", "Borne", "Bornerbroek", "Borssele", "Boskoop", "Botlek Rotterdam", "Bourtange", "Boven Leeuwen", "Bovenkarspel", "Bovensmilde", "Boxmeer", "Boxtel", "Boxtel", "Boxtel", "Braamt", "Brakel", "Brandwijk", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breda", "Breedenbroek", "Breezand", "Breskens", "Breukelen", "Breukelen Ut", "Brielle", "Brielle", "Broek in Waterland", "Broekhuizenvorst", "Broekland Ov", "Bronnegerveen", "Brouwershaven", "Bruchem", "Bruinehaar", "Bruinisse", "Brummen", "Brunssum", "Brunssum", "Brunssum", "Buchten", "Budel", "Budel", "Budel Dorplein", "Budel-Schoot", "Buinerveen", "Buitenpost", "Bunde", "Bunde", "Bunnik", "Bunschoten", "Bunschoten", "Bunschoten Spakenburg", "Bunschoten Spakenburg", "Burdaard", "Buren", "Buren Fr", "Buren Gld", "Burgerbrug", "Burgh-Haamstede", "Burgum", "Bussum", "Bussum", "Bussum", "Cadier en Keer", "Cadzand", "Callantsoog", "Capelle aan den IJssel", "Capelle aan den IJssel", "Capelle aan den IJssel", "Capelle aan den IJssel", "Capelle aan den IJssel", "Capelle aan den IJssel", "Castelre", "Castricum", "Castricum", "Chaam", "Coevorden", "Coevorden", "Colijnsplaat", "Collendoorn", "Colmschate", "Cornwerd", "Cothen", "Creil", "Cromvoirt", "Cuijk", "Cuijk", "Culemborg", "Culemborg", "Culemborg", "Daarle", "Dalen", "Dalerveen", "Dalfsen", "Dalfsen", "Damwoude", "Damwoude", "Darp", "De Beerzen", "De Bilt", "De Bult", "De Cocksdorp", "De Goorn", "De Heen", "De Heurne", "De Kiel", "De Klomp", "De Klomp", "De Koog", "De Krim", "De Kwakel", "De Lier", "De Lutte", "De Meern", "De Moer", "De Pol", "De Punt", "De Rips", "De Schiphorst", "De Steeg", "De Valom", "De Waal", "De Wijk", "De Woude", "Dearsum", "Dedemsvaart", "Dedgum", "Deest", "Delden", "Delfgauw", "Delfstrahuizen", "Delft", "Delft", "Delft", "Delft", "Delfzijl", "Delfzijl", "Den Andel", "Den Bommel", "Den Bommel", "Den Bosch", "Den Burg", "Den Dolder", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Haag", "Den Ham", "Den Ham Ov", "Den Helder", "Den Helder", "Den Helder", "Den Helder", "Den Helder", "Den Helder", "Den Helder", "Den Hoorn Texel", "Den Hoorn Zh", "Den Hout", "Den Hout Nb", "Den Ilp", "Den Oever", "Denekamp", "Deurne", "Deurne", "Deurningen", "Deurningen", "Deventer", "Deventer", "Deventer", "Deventer", "Deventer", "Didam", "Didam", "Didam", "Diemen", "Diepenheim", "Diepenveen", "Dieren", "Dieren", "Diessen", "Diever", "Dieverbrug", "Diffelen", "Dinteloord", "Dinxperlo", "Dirkshorn", "Dirksland", "Dodewaard", "Doenrade", "Doesburg", "Doesburg", "Doesburg", "Doesburg", "Doetinchem", "Doetinchem", "Doetinchem", "Doetinchem", "Doetinchem", "Doetinchem", "Doetinchem", "Doezum", "Doezum", "Dokkum", "Doldersum", "Domburg", "Dongen", "Dongen", "Dongen", "Dongen", "Dongen", "Donkerbroek", "Doorn", "Doornenburg", "Doornspijk", "Doorwerth", "Dordrecht", "Dordrecht", "Dordrecht", "Dordrecht", "Dordrecht", "Dordrecht", "Dorst", "Drachten", "Drachten", "Drachten", "Drachten", "Dreischor", "Drempt", "Dreumel", "Driebergen", "Driebergen-Rijsenburg", "Driebruggen", "Driemond", "Driesum", "Drijber", "Drimmelen", "Drogeham", "Dronrijp", "Dronten", "Dronten", "Drouwen", "Drunen", "Drunen", "Druten", "Duiven", "Duivendrecht", "Duivendrecht", "Duivendrecht", "Dussen", "Dwingeloo", "Earnewald", "Echt", "Echt", "Echt", "Echteld", "Echten", "Echten Dr", "Eck en Wiel", "Eckelrade", "Edam", "Ede", "Ede", "Ede", "Ede", "Ede", "Ede", "Ederveen", "Ee", "Eede", "Eefde", "Eelde", "Eelderwolde", "Eemnes", "Eemnes", "Eemshaven", "Eemshaven", "Een", "Een West", "Eerbeek", "Eersel", "Ees", "Eesveen", "Eext", "Egchel", "Egmond aan de Hoef", "Egmond aan den Hoef", "Egmond aan Zee", "Egmond binnen", "Egmond-Binnen", "Eibergen", "Eibergen", "Eijsden", "Eijsden", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Eindhoven", "Einighausen", "Elburg", "Elim", "Ellemeet", "Elp", "Elsendorp", "Elshout", "Elsloo", "Elsloo Fr", "Elsloo Lb", "Elspeet", "Elst", "Elst", "Elst", "Elst Gld", "Emmeloord", "Emmeloord", "Emmeloord", "Emmeloord", "Emmeloord", "Emmen", "Emmen", "Emmen", "Emmen", "Emmen", "Emmen", "Emmen", "Emmer Compascuum", "Emmer-Compascuüm", "Empe", "Emst", "Engwierum", "Enkhuizen", "Enkhuizen", "Ens", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enschede", "Enspijk", "Enter", "Enter", "Epe", "Epe", "Epen", "Epse", "Erica", "Erm", "Ermelo", "Ermelo", "Ermelo", "Erp", "Esbeek", "Etten", "Etten Gld", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Etten-Leur", "Europoort Rotterdam", "Eursinge", "Exloo", "Eys", "Farmsum", "Ferwerd", "Ferwert", "Fijnaart", "Fijnaart", "Finsterwolde", "Fochteloo", "Follega", "Foxhol", "Franeker", "Franeker", "Frederiksoord", "Froombosch", "Gaastmeer", "Gameren", "Gapinge", "Garderen", "Garyp", "Gasselte", "Gasselternijv. Mond", "Gasselternijveen", "Geersdijk", "Geertruidenberg", "Gees", "Geesbrug", "Geesteren", "Geesteren Gld", "Geesteren Ov", "Geeuwenbrug", "Geffen", "Geijsteren", "Geldermalsen", "Geldrop", "Geldrop", "Geldrop", "Geldrop", "Geldrop", "Geldrop-Mierlo", "Geleen", "Geleen", "Geleen", "Geleen", "Geleen", "Gemert", "Genderen", "Gendringen", "Gendt", "Genemuiden", "Gennep", "Gennep", "Gerkesklooster", "Gersloot", "Giekerk", "Giesbeek", "Giessen", "Giessenburg", "Giessendam", "Gieten", "Gieterveen", "Giethmen", "Giethoorn", "Gilze", "Ginnum", "Glane", "Glanerbrug", "Goedereede", "Goes", "Goes", "Goirle", "Goor", "Goor", "Gorinchem", "Gorinchem", "Gorinchem", "Gorinchem", "Gorinchem", "Gorredijk", "Gorssel", "Gouda", "Gouda", "Gouda", "Gouda", "Gouda", "Gouda", "Gouderak", "Goudriaan", "Goudswaard", "Graft", "Graft-De Rijp", "Graft-De Rijp", "Gramsbergen", "Grashoek", "Grathem", "Grave", "Gravendeel", "Gravenzande", "Grijpskerk", "Groede", "Groenekan", "Groenlo", "Groesbeek", "Groesbeek", "Groet", "Grolloo", "Groningen", "Groningen", "Groningen", "Groningen", "Groningen", "Groningen", "Groningen", "Groningen", "Groningen", "Gronsveld", "Groot Ammers", "Grootebroek", "Grootegast", "Grou", "Grubbenvorst", "Gulpen", "Gytsjerk", "Haaften", "Haaksbergen", "Haaksbergen", "Haamstede", "Haaren", "Haarle Gem Hellend.", "Haarle Gem Tubbergen", "Haarlem", "Haarlem", "Haarlem", "Haarlem", "Haarlem", "Haarlem", "Haarlo", "Haarzuilens", "Haastrecht", "Haelen", "Hagestein", "Haghorst", "Halfweg", "Halfweg Nh", "Hall", "Halle", "Hallum", "Halsteren", "Handel", "Hank", "Hantumeruitburen", "Hapert", "Haps", "Harbrinkhoek", "Hardenberg", "Hardenberg", "Harderwijk", "Harderwijk", "Harderwijk", "Harderwijk", "Harderwijk", "Hardinxveld", "Hardinxveld Giessendam", "Hardinxveld-Giessendam", "Haren", "Haren", "Harfsen", "Harich", "Harkstede", "Harlingen", "Harlingen", "Harmelen", "Harskamp", "Haskerhorne", "Hasselt", "Hattem", "Hattem", "Hattemerbroek", "Haule", "Haulerwijk", "Havelte", "Hazerswoude Dorp", "Hazerswoude Rijndijk", "Hazerswoude-Dorp", "Hazerswoude-Rijndijk", "Hedel", "Heeg", "Heeg", "Heemserveen", "Heemskerk", "Heemskerk", "Heemskerk", "Heemskerk", "Heemskerk", "Heemstede", "Heemstede", "Heemstede", "Heenvliet", "Heerde", "Heerenveen", "Heerenveen", "Heerenveen", "Heerenveen", "Heerenveen", "Heerhugowaard", "Heerhugowaard", "Heerhugowaard", "Heerhugowaard", "Heerjansdam", "Heerjansdam", "Heerle", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heerlen", "Heesch", "Heeswijk Dinther", "Heeten", "Heeze", "Hei en Boeicop", "Heide", "Heijen", "Heijenrath", "Heijningen", "Heiloo", "Heiloo", "Heinenoord", "Heinkenszand", "Heino", "Helden", "Hellendoorn", "Hellevoetsluis", "Hellevoetsluis", "Hellevoetsluis", "Helmond", "Helmond", "Helmond", "Helmond", "Helmond", "Helmond", "Helvoirt", "Hemelum", "Hempens", "Hemrik", "Hendrik Ido Ambacht", "Hendrik Ido Ambacht", "Hendrik-Ido-Ambacht", "Hendrik-Ido-Ambacht", "Hengelo", "Hengelo", "Hengelo (G)", "Hengelo GL", "Hengelo Gld", "Hengelo Ov", "Hengelo OV", "Hengelo Ov", "Hengelo Ov", "Hengelo Ov", "Hengelo OV", "Hengstdijk", "Herkenbosch", "Herkingen", "Herpen", "Herten", "Hertme", "Herwen", "Herwijnen", "Heteren", "Heukelom Nb", "Heusden", "Heusden Gem Asten", "Heythuysen", "Hezingen", "Hiaure", "Hierden", "Hieslum", "Hijken", "Hilaard", "Hillegom", "Hillegom", "Hilvarenbeek", "Hilversum", "Hilversum", "Hilversum", "Hilversum", "Hilversum", "Hindeloopen", "Hippolytushoef", "Hoek", "Hoek van Holland", "Hoenderloo", "Hoensbroek", "Hoevelaken", "Hoeven", "Hof van Twente", "Hoge Hexel", "Hollandsche Rading", "Hollandscheveld", "Hollum", "Holsloot", "Holten", "Holtheme", "Holwerd", "Holwierde", "Hommerts", "Honselersdijk", "Hoofddorp", "Hoofddorp", "Hoofddorp", "Hoofddorp", "Hooge Mierde", "Hoogeloon", "Hoogerheide", "Hoogersmilde", "Hoogeveen", "Hoogeveen", "Hoogeveen", "Hoogeveen", "Hoogeveen", "Hoogeveen", "Hoogezand", "Hoogezand", "Hoogezand", "Hoogezand-Sappemeer", "Hooghalen", "Hoogkarspel", "Hoogland", "Hoog-Soeren", "Hoogvliet", "Hoogvliet Rotterdam", "Hoogwoud", "Hoorn", "Hoorn", "Hoorn", "Hoorn", "Hoorn Nh", "Hoorn Nh", "Hoorn Nh", "Hoornaar", "Hoornaar", "Horst", "Houten", "Houten", "Houten", "Huijbergen", "Huis Ter Heide Dr", "Huis Ter Heide Ut", "Huisseling", "Huissen", "Huissen", "Huizen", "Huizen", "Huizen", "Huizen", "Hulsberg", "Hulsel", "Hulshorst", "Hulst", "Hummelo", "Hunsel", "Hurdegaryp", "Idsegahuizum", "Idzega", "IJhorst", "IJlst", "Ijmuiden", "IJmuiden", "Ijmuiden", "IJmuiden", "Ijmuiden", "Ijsselmuiden", "IJsselstein Ut", "IJsselstein Ut", "IJzendijke", "Ilpendam", "Ingen", "It Heidenskip", "Ittervoort", "Jannum", "Jirnsum", "Jislum", "Jisp", "Jistrum", "Jonkersvaart", "Joure", "Joure", "Jubbega", "Julianadorp", "Kaag", "Kaatsheuvel", "Kalenberg", "Kallenkote", "Kamerik", "Kampen", "Kampen", "Kampen", "Kampen", "Kampen", "Kampen-c", "Kamperland", "Kapel Avezaath Buren", "Kapelle", "Kats", "Kattendijke", "Katwijk", "Katwijk", "Katwijk Nb", "Katwijk Zh", "Katwijk Zh", "Kelpen-Oler", "Kelpen-Oler", "Kerkdriel", "Kerkrade", "Kerkrade", "Kerkrade", "Kerkrade", "Kerkrade", "Kerkwerve", "Kessel", "Kessel Lb", "Kesteren", "Kiel Windeweer", "Kimswerd", "Klaaswaal", "Klarenbeek", "Klazienaveen", "Kleine Sluis", "Klijndijk", "Klimmen", "Klooster Lidlum", "Kloosterburen", "Kloosterzande", "Klundert", "Kockengen", "Kockengen", "Koekange", "Koewacht", "Kolham", "Kolhorn", "Kollum", "Kollum", "Kollum", "Kollumerpomp", "Kollumerzwaag", "Koningsbosch", "Koningslust", "Koog aan de Zaan", "Kootstertille", "Kootwijk", "Kootwijkerbroek", "Kornhorn", "Kortehemmen", "Kortenhoef", "Kortgene", "Koudekerk aan den Rijn", "Koudekerke", "Koudum", "Koudum", "Krabbendijke", "Kraggenburg", "Krimpen aan den IJssel", "Krimpen aan de Lek", "Krimpen aan den IJssel", "Krimpen aan den IJssel", "Kring van Dorth", "Krommenie", "Kronenberg", "Kruiningen", "Kruisland", "Kuinre", "Kwadijk", "Laag Soeren", "Lage Mierde", "Lage Zwaluwe", "Lageland", "Lambertschaag", "Lamswaarde", "Landgraaf", "Landgraaf", "Landgraaf", "Landgraaf", "Landsmeer", "Langbroek", "Langelille", "Langenboom", "Langerak", "Langeveen", "Langeweg", "Langweer", "Langweer", "Laren", "Laren", "Laren Gld", "Lathum", "Lattrop Breklenkamp", "Lauwersoog", "Lauwerzijl", "Ledeacker", "Leek", "Leende", "Leens", "Leens", "Leerdam", "Leerdam", "Leersum", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leeuwarden", "Leiden", "Leiden", "Leiden", "Leiden", "Leiden", "Leiderdorp", "Leiderdorp", "Leidschendam", "Leidschendam", "Leidschendam", "Leimuiden", "Lekkerkerk", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lelystad", "Lemele", "Lemelerveld", "Lemelerveld", "Lemiers", "Lemmer", "Lent", "Lettele", "Leusden", "Leusden", "Leusden", "Lewedorp", "Lexmond", "Lichtenvoorde", "Liempde", "Lienden", "Lieren", "Lierop", "Lieshout", "Liessel", "Lievelde", "Lijnden", "Limmen", "Linden", "Linschoten", "Lisse", "Lisse", "Lisserbroek", "Lith", "Lobith", "Lochem", "Lochem", "Loenen", "Loenen aan de Vecht", "Loenen aan de Vecht", "Loenen Gld", "Loenga", "Lomm", "Loon op Zand", "Loosdrecht", "Loozen", "Lopik", "Lopikerkapel", "Loppersum", "Losser", "Losser", "Lottum", "Luchthaven Schiphol", "Lunteren", "Lutjewinkel", "Luttelgeest", "Luttenberg", "Luyksgestel", "Maarheeze", "Maarn", "Maarsbergen", "Maarssen", "Maarssen", "Maarssen", "Maarssen", "Maarssen", "Maarssenbroek", "Maartensdijk", "Maasbommel", "Maasbracht", "Maasbree", "Maasdam", "Maasdijk", "Maashees", "Maasland", "Maassluis", "Maassluis", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maastricht", "Maasvlakte Rotterdam", "Made", "Makkum", "Makkum Fr", "Makkum Fr", "Malden", "Mander", "Mantgum", "Margraten", "Margraten", "Maria Hoop", "Mariahout", "Mariaparochie", "Marienberg", "Mariónberg", "Markelo", "Marken", "Marknesse", "Marrum", "Marssum", "Marum", "Marwijksoord", "Matsloot", "Maurik", "Mechelen", "Medemblik", "Meedhuizen", "Meerkerk", "Meerlo", "Meerssen", "Megchelen", "Megen", "Meijel", "Melderslo", "Melick", "Melissant", "Menaldum", "Menaldum", "Meppel", "Meppel", "Meppel", "Meppen", "Merselo", "Meterik", "Mheer", "Middelaar", "Middelburg", "Middelburg", "Middelburg", "Middelburg", "Middelburg", "Middelharnis", "Middelstum", "Middenbeemster", "Middenmeer", "Midlaren", "Midlum", "Midwolda", "Midwolde", "Midwoud", "Mierlo", "Mijdrecht", "Mijnsheerenland", "Mijnsheerenland", "Milheeze", "Mill", "Mill", "Millingen aan de Rijn", "Milsbeek", "Moerdijk", "Moerdijk", "Moergestel", "Moerkapelle", "Moerstraten", "Molenhoek Lb", "Molenschot", "Molkwerum", "Monnickendam", "Monster", "Montfoort", "Montfort", "Mook", "Mookhoek", "Moordrecht", "Moordrecht", "Morra", "Muiden", "Muiderberg", "Muntendam", "Mussel", "Musselkanaal", "Naaldwijk", "Naarden", "Naarden", "Nagele", "Nederhemert", "Nederhorst den Berg", "Nederweert", "Nederweert Eind", "Neede", "Neer", "Neerijnen", "Neerkant", "Nes", "Nes Ameland", "Nes Gem Dongeradeel", "Netersel", "Netterden", "Nibbixwoud", "Niebert", "Niedorp", "Niekerk Grootegast", "Nietap", "Nieuw Amsterdam", "Nieuw Balinge", "Nieuw Beijerland", "Nieuw Buinen", "Nieuw Dordrecht", "Nieuw Heeten", "Nieuw Lekkerland", "Nieuw Roden", "Nieuw Vennep", "Nieuw Vennep", "Nieuw Vennep", "Nieuw Vossemeer", "Nieuw Weerdinge", "Nieuw-Beijerland", "Nieuwdorp", "Nieuwe Niedorp", "Nieuwe Pekela", "Nieuwe Tonge", "Nieuwegein", "Nieuwegein", "Nieuwegein", "Nieuwegein", "Nieuwegein", "Nieuwegein", "Nieuwehorne", "Nieuwendijk Nb", "Nieuwer ter Aa", "Nieuwerbrug", "Nieuwerkerk", "Nieuwerkerk aan den IJssel", "Nieuwerkerk aan den IJssel", "Nieuweroord", "Nieuweschans", "Nieuwkoop", "Nieuwkuijk", "Nieuwland", "Nieuw-Lekkerland", "Nieuwleusen", "Nieuw-Namen", "Nieuwolda", "Nieuwveen", "Nieuw-Vennep", "Nieuwvliet", "Nieuw-Vossemeer", "Nigtevecht", "Nigtevecht", "Nij Beets", "Nijehaske", "Nijemirdum", "Nijensleek", "Nijeveen", "Nijhuizum", "Nijkerk", "Nijkerk", "Nijkerk Gld", "Nijkerk Gld", "Nijkerkerveen", "Nijland", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijmegen", "Nijswiller", "Nijverdal", "Nijverdal", "Nijverdal", "Nispen", "Nistelrode", "Nooitgedacht", "Noorbeek", "Noord Sleen", "Noordbroek", "Noorden", "Noorden", "Noordhorn", "Noord-Scharwoude", "Noordscheschut", "Noordwelle", "Noordwijk", "Noordwijk", "Noordwijk", "Noordwijk Gn", "Noordwijk Zh", "Noordwijk Zh", "Noordwijk Zh", "Noordwijkerhout", "Noordwolde", "Norg", "Nuenen", "Nuenen", "Nuenen", "Nuland", "Numansdorp", "Nunspeet", "Nunspeet", "Nuth", "Nutter", "Obdam", "Ochten", "Odijk", "Odiliapeel", "Odoorn", "Odoornerveen", "Oeffelt", "Oegstgeest", "Oegstgeest", "Oene", "Offingawier", "Oh en Laak", "Oirlo", "Oirsbeek", "Oirschot", "Oisterwijk", "Oisterwijk", "Oldeberkoop", "Oldebroek", "Oldeholtwolde", "Oldehove", "Oldemarkt", "Oldenzaal", "Oldenzaal", "Oldenzaal", "Oldenzaal", "Oldenzaal", "Oldeouwer", "Olst", "Olst-Wijhe", "Ommel", "Ommen", "Ommeren", "Onnen", "Onstwedde", "Ooltgensplaat", "Oost W en Middelbeers", "Oostburg", "Oosterbeek", "Oosterend Nh", "Oosterhesselen", "Oosterhout", "Oosterhout", "Oosterhout", "Oosterhout", "Oosterhout (Nijmegen)", "Oosterhout GLD", "Oosterhout Gld", "Oosterhout Nb", "Oosterhout Nb", "Oosterhout Nb", "Oosterland", "Oosternijkerk", "Oosterstreek", "Oosterwolde", "Oosthuizen", "Oostkapelle", "Oostknollendam", "Oostrum Fr", "Oostvoorne", "Oostwold Scheemda", "Oostwoud", "Oostzaan", "Ootmarsum", "Opeinde", "Opende", "Ophemert", "Opheusden", "Oploo", "Opmeer", "Opmeer", "Opperdoes", "Orvelte", "Ospel", "Oss", "Oss", "Oss", "Oss", "Oss", "Ossendrecht", "Ossenisse", "Ossenzijl", "Oterleek", "Otterlo", "Ottoland", "Oud Ade", "Oud Beijerland", "Oud Beijerland", "Oud Beijerland", "Oud Gastel", "Oud Ootmarsum", "Oud-Alblas", "Oud-Beijerland", "Ouddorp", "Ouddorp Zh", "Oude Meer", "Oude Pekela", "Oude Tonge", "Oude Willem", "Oudega Gaast Sleat", "Oudega Gem Small.", "Oudega Gem Wymbr.", "Oudemirdum", "Oudenbosch", "Oudenhoorn", "Ouderkerk a/d Amstel", "Ouderkerk aan de Amstel", "Ouderkerk aan den Amstel", "Ouderkerk aan den IJssel", "Oudeschild", "Oudeschoot", "Oudesluis", "Oude-Tonge", "Oudewater", "Oud-Gastel", "Oudorp", "Oudwoude", "Ouwerkerk", "Overasselt", "Overberg", "Overdinkel", "Overloon", "Overveen", "Ovezande", "Paasloo", "Pannerden", "Panningen", "Papendrecht", "Papendrecht", "Papendrecht", "Papenvoort", "Parrega", "Parrega", "Paterswolde", "Peize", "Pesse", "Petten", "Piershil", "Pieterburen", "Pijnacker", "Pingjum", "Plasmolen", "Poeldijk", "Poortugaal", "Poortugaal", "Poortvliet", "Posterholt", "Prinsenbeek", "Purmerend", "Purmerend", "Purmerend", "Purmerend", "Purmerend", "Purmerend", "Putte", "Putten", "Putten", "Puttershoek", "Raalte", "Raalte", "Raalte", "Raamsdonksveer", "Raard", "Radewijk", "Randwijk", "Ransdaal", "Ransdorp", "Ravenstein", "Reahus", "Reek", "Reeuwijk", "Reeuwijk", "Reijmerstok", "Rekken", "Renesse", "Renesse", "Renkum", "Renswoude", "Retranchement", "Reusel", "Reutum", "Reuver", "Rheden", "Rhee", "Rheeze", "Rheezerveen", "Rhenen", "Ridderkerk", "Ridderkerk", "Ridderkerk", "Ridderkerk", "Ridderkerk", "Riel", "Riethoven", "Rietmolen", "Rijen", "Rijkevoort", "Rijnsburg", "Rijpwetering", "Rijs", "Rijsbergen", "Rijsenhout", "Rijssen", "Rijssen", "Rijswijk", "Rijswijk", "Rijswijk Zh", "Rijswijk Zh", "Rijswijk Zh", "Rijswijk Zh", "Rilland", "Rinsumageest", "Ritthem", "Ritthem", "Ritthem", "Ritthem", "Rockanje", "Roden", "Roelofarendsveen", "Roermond", "Roermond", "Roermond", "Rogat", "Roggel", "Rohel", "rolde", "Rolde", "Roodeschool", "Roosendaal", "Roosendaal", "Roosendaal", "Roosendaal", "Roosendaal", "Roosendaal", "Roosteren", "Rosmalen", "Rosmalen", "Rossum", "Rossum Ov", "Roswinkel", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rotterdam", "Rouveen", "Rozenburg", "Rozenburg Nh", "Rozenburg Zh", "Rozendaal", "Rucphen", "Ruigahuizen", "Ruinen", "Ruinerwold", "Rumpt", "Rutten", "Ruurlo", "Rykevoort-De Walsert", "Saaksum", "Saasveld", "Sandfirden", "Sappemeer", "Sas van Gent", "Sassenheim", "Schagen", "Schagen", "Schagerbrug", "Schagerbrug", "Schaijk", "Schalkhaar", "Schalkwijk", "Schardam", "Scharendijke", "Scharmer", "Scharsterbrug", "Scheemda", "Scheerwolde", "Schellinkhout", "Schelluinen", "Scherpenisse", "Scherpenzeel", "Scherpenzeel FR", "Scherpenzeel Gld", "Schiedam", "Schiedam", "Schiedam", "Schiedam", "Schiedam", "Schiermonnikoog", "Schijf", "Schijndel", "Schijndel", "Schildwolde", "Schin op Geul", "Schinnen", "Schinnen", "Schinveld", "Schipborg", "Schiphol", "Schiphol", "Schiphol-Rijk", "Schipluiden", "Schoondijke", "Schoonebeek", "Schoonebeek", "Schoonhoven", "Schoonloo", "Schoonoord", "Schoonrewoerd", "Schoorl", "Sellingen", "Serooskerke", "Sevenum", "Sexbierum", "'S-Gravendeel", "s-Gravenmoer", "s-Gravenpolder", "s-Gravenzande", "'S-Gravenzande", "s-Heer Arendskerke", "'S-Heerenberg", "'S-Heerenbroek", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "s-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "'S-Hertogenbosch", "Sibculo", "Siddeburen", "Siebengewald", "Siegerswoude", "Sijbekarspel", "Silvolde", "Simpelveld", "Sinderen", "Sint Agatha", "Sint Annaland", "Sint Annaparochie", "Sint Anthonis", "Sint Geertruid", "Sint Hubert", "Sint Jacobiparochie", "Sint Jansklooster", "Sint Maarten", "Sint Maartensbrug", "Sint Maartensdijk", "Sint Maartensvlotbrug", "Sint Nicolaasga", "Sint Nicolaasga", "Sint Odiliënberg", "Sint Odiliónberg", "Sint Philipsland", "Sint-Annaland", "Sint-Kruis", "Sint-Maartensdijk", "Sint-Michielsgestel", "Sint-Oedenrode", "Sint-Oedenrode", "Sirjansland", "Sittard", "Sittard", "Sittard", "Sittard", "Slagharen", "Sleen", "Sleeuwijk", "Sliedrecht", "Sliedrecht", "Slijk Ewijk", "Slochteren", "Slootdorp", "Sloten", "Sluis", "Sluiskil", "Smakt", "Smilde", "Sneek", "Sneek", "Sneek", "Snelrewaard", "Soerendonk", "Soest", "Soest", "Soest", "Soest", "Soesterberg", "Someren", "Someren", "Sommelsdijk", "Sommelsdijk", "Son", "Son", "Sondel", "Spaarndam", "Spanbroek", "Spier", "Spijk Gn", "Spijkenisse", "Spijkenisse", "Spijkenisse", "Spijkenisse", "Spijkerboor", "Sprang-Capelle", "Sprundel", "Stad aan 't Haringvliet", "Stadskanaal", "Stadskanaal", "Stadskanaal", "Stamproy", "Standdaarbuiten", "Staphorst", "Stavenisse", "Stavoren", "Steenbergen", "Steenbergen", "Steenbergen Dr", "Steenbergen Nb", "Steendam", "Steenderen", "Steenwijk", "Steenwijk", "Stegeren", "Steggerda", "Stein", "Stein Lb", "Stellendam", "Sterksel", "Stevensbeek", "Stevensweert", "Stieltjeskanaal", "Stiens", "Stokkum", "Stolwijk", "Stompetoren", "Stramproy", "Strijbeek", "Strijen", "Stroe", "Stroobos", "Stuifzand", "Sumar", "Surhuisterveen", "Susteren", "Susteren", "Swalmen", "Swifterbant", "Swolgen", "'T Goy", "t Harde", "'T Harde", "'T Loo Oldebroek", "'T Zand Nh", "Tegelen", "Ten Boer", "Ten Post", "Ter Aar", "Ter Apel", "Terborg", "Terheijden", "Terherne", "Terkaple", "Termunterzijl", "Ternaard", "Terneuzen", "Terneuzen", "Teroele", "Terschelling Formerum", "Terschelling Hee", "Terschelling Hoorn", "Terschelling Kinnum", "Terschelling Landerum", "Terschelling Lies", "Terschelling Midsland", "Terschelling O.End", "Terschelling West", "Terschuur", "Terwolde", "Teteringen", "Teuge", "Tholen", "Thorn", "Tiel", "Tiel", "Tiel", "Tiel", "Tiel", "Tiendeveen", "Tienhoven Ut", "Tienray", "Tijnje", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tilburg", "Tinte", "Tolkamer", "Triemen", "Tripscompagnie", "Tubbergen", "Tuitjenhorn", "Tull en 'T Waal", "Tweede Exloermond", "Tweede Exloërmond", "Twello", "Twijzel", "Twisk", "Tynaarlo", "Tytsjerk", "Tzum", "Tzummarum", "Uddel", "Uden", "Uden", "Uden", "Uden", "Udenhout", "Uffelte", "Ugchelen", "Uitdam", "Uitgeest", "Uithoorn", "Uithoorn", "Uithoorn", "Uithuizen", "Uithuizermeeden", "Uitwellingerga", "Ulestraten", "Ulft", "Ulicoten", "Ulrum", "Ulvenhout", "Ureterp", "Urk", "Ursem", "Usquert", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Utrecht", "Vaals", "Vaassen", "Vaassen", "Valburg", "Valkenburg", "Valkenburg", "Valkenburg aan de Geul", "Valkenburg Lb", "Valkenburg Zh", "Valkenswaard", "Valkenswaard", "Valkenswaard", "Valthermond", "Varik", "Varsseveld", "Vasse", "Veen", "Veendam", "Veendam", "Veendam", "Veenendaal", "Veenendaal", "Veenendaal", "Veenendaal", "Veenhuizen", "Veenoord", "Veenwouden", "Veenwouden", "Veere", "Veessen", "Vegelinsoord", "Veghel", "Veghel", "Veghel", "Veghel", "Veghel", "Veghel", "Veghel", "Velddriel", "Velden", "Veldhoven", "Veldhoven", "Veldhoven", "Veldhoven", "Veldhoven", "Veldhoven", "Velp", "Velp Gld", "Velp Nb", "Velsen", "Velsen-Noord", "Velsen-Zuid", "Venhorst", "Venhuizen", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venlo", "Venray", "Venray", "Vessem", "Vianen", "Vianen Ut", "Vianen Ut", "Vierakker", "Vierhouten", "Vierhuizen", "Vierlingsbeek", "Vierpolders", "Vijfhuizen", "Vijlen", "Vilsteren", "Vinkega", "Vinkeveen", "Visvliet", "Vlaardingen", "Vlaardingen", "Vlaardingen", "Vlaardingen", "Vlagtwedde", "Vledder", "Vledderveen Dr", "Vleuten", "Vlieland", "Vlierden", "Vlijmen", "Vlissingen", "Vlissingen", "Vlissingen", "Vlissingen", "Vlodrop", "Voerendaal", "Vogelenzang", "Vogelwaarde", "Volendam", "Volendam", "Volendam", "Volkel", "Vollenhove", "Vondelingenplaat Rt", "Voorburg", "Voorburg", "Voorhout", "Voorschoten", "Voorschoten", "Voorst", "Voorst Gem Voorst", "Voorthuizen", "Vorden", "Vragender", "Vredepeel", "Vreeland", "Vreeland", "Vries", "Vriescheloo", "Vriezenveen", "Vroomshoop", "Vrouwenparochie", "Vrouwenpolder", "Vught", "Vught", "Vught", "Vuren", "Waalre", "Waalre", "Waalre", "Waalwijk", "Waalwijk", "Waalwijk", "Waardenburg", "Waarland", "Waddinxveen", "Waddinxveen", "Wagenborgen", "Wageningen", "Wageningen", "Wageningen", "Wageningen", "Walem", "Walsoorden", "Wanneperveen", "Wanroij", "Wanssum", "Wapenveld", "Wapse", "Wapserveen", "Warder", "Warffum", "Warfhuizen", "Warfstermolen", "Warmenhuizen", "Warmond", "Warns", "Warnsveld", "Warten", "Waskemeer", "Waspik", "Wassenaar", "Wassenaar", "Wassenaar", "Wassenaar", "Wateren", "Watergang", "Wateringen", "Waverveen", "Wedde", "Weerselo", "Weert", "Weert", "Weert", "Weert", "Weert", "Weesp", "Weesp", "Wehe Den Hoorn", "Wehl", "Weidum", "Wekerom", "Well Lb", "Wellerlooi", "Welsum", "Wemeldinge", "Wenum Wiesel", "Werkendam", "Werkhoven", "Wernhout", "Wervershoof", "Wervershoof", "Wervershoof", "Wesepe", "Wessem", "Westbeemster", "Westbroek", "Westdorpe", "Westendorp", "Westerbork", "Westerbroek", "Westergeest", "Westerhaar-Vriezenv W", "Westerhaar-Vriezenv Wijk", "Westerhoven", "Westerland", "Westerlee Gn", "Westernieland", "Westervoort", "Westhoek", "Westkapelle", "Westkapelle", "Westland", "Westmaas", "West-Terschelling", "Westvoorne", "Westwoud", "Wetering", "Wetzens", "Weurt", "Wezep", "Wezuperbrug", "Wichmond", "Wierden", "Wierden", "Wieringermeer", "Wieringerwaard", "Wieringerwerf", "Wieringerwerf", "Wijchen", "Wijchen", "Wijckel", "Wijdenes", "Wijhe", "Wijk Aan Zee", "Wijk bij Duurstede", "Wijk bij Duurstede", "Wijk en Aalburg", "Wijk en Aalburg", "Wijlre", "Wijnaldum", "Wijngaarden Zh", "Wijnjewoude", "Wijster", "Wilbertoord", "Wildervank", "Wildervank", "Wilhelminadorp", "Willemstad", "Willemstad Nb", "Wilnis", "Wilp", "Windraak", "Winkel", "Winschoten", "Winschoten", "Winschoten", "Winschoten", "Winschoten", "Winssen", "Winsum", "Winsum Gn", "Wintelre", "Winterswijk", "Winterswijk", "Winterswijk", "Winterswijk Henxel", "Winterswijk Huppel", "Winterswijk Kotten", "Winterswijk Meddo", "Winterswijk Miste", "Winterswijk Woold", "Wissenkerke", "Witmarsum", "Witmarsum", "Witte Paarden", "Wittelte", "Witteveen", "Woensdrecht", "Woerden", "Woerden", "Woerden", "Woerden", "Woerden", "Woerden", "Woerden", "Woerdense Verlaat", "Wognum", "Woldendorp", "Wolfheze", "Wolphaartsdijk", "Wolsum", "Wolvega", "Wommels", "Workum", "Workum", "Workum", "Workum", "Wormer", "Wormerveer", "Woubrugge", "Woudenberg", "Woudrichem", "Wouterswoude", "Wouw", "Wouwse Plantage", "Yerseke", "Ysselsteyn L", "Ysselsteyn Lb", "Zaamslag", "Zaandam", "Zaandam", "Zaandam", "Zaandam", "Zaandam", "Zaandam", "Zaandam", "Zaandijk", "Zalk", "Zaltbommel", "Zandhuizen", "Zandpol", "Zandvoort", "Zandvoort", "Zeddam", "Zeegse", "Zeeland", "Zeerijp", "Zeewolde", "Zeewolde", "Zeewolde", "Zeewolde", "Zeewolde", "Zegge", "Zegveld", "Zeist", "Zeist", "Zeist", "Zeist", "Zeist", "Zelhem", "Zetten", "Zevenaar", "Zevenaar", "Zevenaar", "Zevenaar", "Zevenbergen", "Zevenbergen", "Zevenbergen", "Zevenhuizen", "Zevenhuizen Zh", "Zierikzee", "Zijdewind", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoetermeer", "Zoeterwoude", "Zoeterwoude", "Zonnemaire", "Zorgvlied", "Zoutelande", "Zoutkamp", "Zuid-Beijerland", "Zuidbroek", "Zuiddorpe", "Zuidhorn", "Zuidlaarderveen", "Zuidland", "Zuidlaren", "Zuidlaren", "Zuidoostbeemster", "Zuid-Scharwoude", "Zuidwolde", "Zuidwolde Dr", "Zuidwolde Gn", "Zuilichem", "Zuna", "Zundert", "Zundert", "Zundert", "Zutphen", "Zutphen", "Zutphen", "Zutphen", "Zutphen", "Zwaag", "Zwaagdijk", "Zwaagwesteinde", "Zwammerdam", "Zwanenburg", "Zwartebroek", "Zwartemeer", "Zwartewaal", "Zwartewaterland", "Zwartsluis", "Zweeloo", "Zwiggelte", "Zwijndrecht"};
    ArrayList<Field> fields = new ArrayList<>();

    public static void main(String[] args) {


        Field field;
        Field field2;
        try {
            Lemming l = new Lemming(field);
            field.dummy2();
            field2.dummy2();
            l.verhuis(field2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void createFields() {
        int i = 0;
        for (String string : CITY_NAMES) {
            try {
                Field f = new Field(25565 + i, string);
                Thread t = new Thread(f);
                t.start();
                FieldView fv = new FieldView(f);
                fv.setVisible(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            i++;
        }
    }
}
