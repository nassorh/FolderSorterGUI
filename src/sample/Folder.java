package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Folder {
    File directory;
    //Init database
    ArrayList<File> files = new ArrayList<File>();
    List<String> database = Arrays.asList("264:15","3dm:2","3ds:2","3g2:15","3ga:1","3gp:15","3gpp:15","7z:0","8bi:9","Rasterimagefileformats:11"
            ,"Vectorimagefileformats:14","aa:1","aac:1","aae:3","aax:1","accdb:4","ace:0","acsm:7","act:12","adoc:6","adpcm:1","adt:3","aep:15",
            "ai:14","aif:1","aifc:1","aiff:1","air:8","amr:1","amv:15","ani:14","apa:5","ape:1","api:12","apk:0","apnx:7","app:8","approj:9","arf:15",
            "art:11","arw:11","asc:5","asf:15","asm:5","asp:16","aspx:16","asw:12","asx:1","au:1","aup:1","avi:15","avif:11","awb:1","azw3:7","azw:7","b:5"
            ,"bak:9","bas:5","bash_history:14","bash_profile:14","bashrc:14","bat:8","bbl:9","bet:5","bfc:9","bib:9","bibtex:9","bik:15","bin:14","bluej:5"
            ,"bmp:11","bok:3","bud:14","bup:4","bz2:0","c:5","cab:14","caf:1","caj:10","camproj:15","camrec:15","cat:14","cbl:5","cbr:7","cbt:7","cbz:7"
            ,"ccc:5","cd:5","cda:1","cdo:1","cdr:14","cdt:12","ced:15","cel:3","cer:16","cff:9","cfg:12","cfm:16","cfml:16","cgi:8","chm:6","class:5","clp:3"
            ,"cma:3","cmd:8","cmf:9","cmproj:15","cmrec:15","cod:5","com:8","cpi:15","cpl:14","cpp:5","cr2:11","crdownload:9","crw:11","crx:0","crypt:4",
            "cs:5","csk:6","csr:16","css:16","csv:13","cue:9","cur:14","cvs:14","d:5","dao:9","dat:14","dav:15","db:4","dbf:4","dbx:9","dcm:11","dd:0",
            "dds:11","deb:0","def:5","dem:9","deskthemepack:14","dev:14","dic:9","dif:3","dir:15","dit:14","divx:15","djvu:11","dll:14","dmg:9","dmp:14",
            "dng:11","do:16","doc:6","docm:6","docx:6","dot:6","dotx:6","drv:14","ds:8","dtd:5","dtp:10","dun:12","dvd:14","dvsd:15","dwg:2","dxf:2","ebd:14"
            ,"eddx:10","efx:3","emf:14","eml:6","emz:14","enc:9","enl:9","ens:9","enw:9","epc:9","eps:14","epub:7","erb:5","esp3:15","exe:8","exr:11",
            "f4v:15","fb2:7","fcpevent:3","fdxt:6","ffl:14","ffo:14","fla:5","flac:1","flif:11","flipchart:11","flo:3","flt:9","flv:15","fm3:12","fnt:9",
            "fon:9","fota:14","fpx:11","fsproj:5","fxc:5","g64:15","gadget:8","gam:9","gbr:3","gcw:3","ged:3","gho:9","gid:12","gif:11","gms:3","gpx:9",
            "grp:9","gsm:1","gvdesign:14","gz:0","gzip:0","h264:15","h:5","hdmp:14","hdr:11","heic:11","hex:9","hiv:14","hlp:14","hpp:5","hqx:9","ht:12",
            "htm:16","html:16","htt:14","hwp:6","i5z:3","ibooks:7","icl:14","icm:12","icns:14","ico:11","iconpackage:14","ics:9","idx:9","iff:1","ifo:15",
            "img:9","imoviemobile:15","indd:10","inf:12","ini:12","ion:14","ip:3","ipa:8","iptheme:14","ise:5","iso:9","ithmb:11","itl:3","iwb:5","jad:9",
            "jar:0","java:5","jp2:11","jpeg:11","jpg:11","js:16","json:16","jsp:16","jxr:11","kar:1","kdc:11","key.zip:11","key:11","keychain:3","kfx:7",
            "kml:9","kmz:9","koz:1","kv:5","lbl:10","lit:7","lnk:14","log:6","lrf:7","lua:5","m2ts:15","m3u8:1","m3u:6","m4:5","m4a:1","m4b:1","m4p:1",
            "m4r:1","m4v:15","m:5","mac:11","map:9","marc:9","max:2","mbp:7","md:5","mdb:4","mdf:9","mdi:10","mdmp:14","mepx:15","mht:0","mhtml:16","mid:1",
            "midi:1","mim:9","mime:9","mind:12","mix:14","mkv:15","mlc:14","mmf:1","mobi:7","mod:15","modd:15","mov:15","mp2:1","mp3:1","mp4:15","mpa:1",
            "mpc:1","mpeg:15","mpg:15","mpga:1","mproj:15","mrc:9","msg:6","msi:9","mswmm:15","mtb:9","mts:15","mtw:3","mxf:15","nb0:14","nef:11","nes:9",
            "nfa:1","nfi:3","nfo:14","nfs:3","nfv:15","nib:5","nrw:11","nt:14","numbers:13","nzb:16","o:5","obj:2","odg:14","odm:6","odp:11","ods:13","odt:6",
            "oga:1","ogg:1","ogv:15","oma:1","one:3","opf:7","opus:1","orf:11","ori:9","osp:15","otf:9","ova:3","ovf:3","owl:5","oxps:6","p65:10","p:5",
            "pages.zip:6","pages:6","part:9","pas:5","pb:5","pbj:5","pbxuser:5","pcd:11","pck:14","pct:11","pcx:11","pd:14","pdb:4","pdf:6","pds:15","pef:11",
            "pes:9","pgm:11","php:16","pict:11","pictclipping:11","pif:8","pika:5","pkg:12","pl:5","plist:11","plugin:9","pmd:6","pnf:14","png:11","pol:14",
            "pps:11","ppsx:11","ppt:11","pptm:11","pptx:11","prc:7","prf:12","prop:14","ps:9","psd:11","pspimage:11","pub:6","pwn:5","py:5","pyw:5","qb2011:3",
            "qcp:1","qpr:5","qt:15","quickendata:3","qvm:14","qxd:10","qxp:9","r01:0","ra:1","raf:11","ram:1","rar:0","raw:11","rc:5","rcproject:15","rdf:12",
            "reg:14","rels:10","rem:9","resources:5","ris:9","rm:15","rmvb:15","rom:9","rpm:0","rss:16","rta:1","rtf:6","rwl:11","s19:5","sav:9","sb2:5","sb:5",
            "scr:8","sdf:3","sfw:11","sh:5","shs:6","sit:0","sitx:0","sln:5","sma:5","snb:0","sql:4","sr2:11","srt:15","ss:5","stp:2","suo:5","svg:14","svgz:14"
            ,"swf:15","swift:5","sxw:6","sys:14","t65:9","tar.gz:0","tar:0","tax2012:3","tax2014:3","tax2016:3","tax:3","tcr:7","tec:9","tex:6","tga:11",
            "tgz:0","thm:11","thp:15","tif:11","tiff:11","tmp:9","toast:9","torrent:9","trec:15","trx:5","ts:15","tscproj:12","ttf:9","tvs:15","txt:6","url:9",
            "uue:9","vb:8","vbk:7","vbp:5","vbproj:5","vbx:5","vc:5","vcd:9","vcf:3","vcs:3","vcxproj:5","veg:15","vep:15","vmg:6","vnt:6","vob:15","vpj:15",
            "vproj:15","vsd:14","wav:1","wbmp:11","webarchive:16","webloc:16","webm:15","webp:11","wk3:13","wks:13","wlmp:15","wma:1","wmf:14","wmv:15","wp5:6",
            "wpd:6","wpg:14","wps:6","wsf:8","wwp:5","xap:5","xcf:11","xcodeproj:5","xesc:15","xfdl:16","xhtml:16","xib:5","xll:9","xlr:13","xls:13","xlsb:13",
            "xlsm:13","xlsx:13","xmind:3","xml:6","xps:6","xq:5","xspf:1","xt:5","yml:5","yuv:11","zip:0","zipx:0");
    List<String> categories = Arrays.asList("Archivefileformats","Audiofileformats","CADfileformats","Datafileformats","Databasefileformats",
            "Developerfileformats","Documentfileformats","eBookfileformats","Executablesfileformats","Miscfileformats","PageLayoutfileformats",
            "Presentationfileformats","Settingsfileformats","Spreadsheetfileformats","Systemfileformats","Videofileformats","Websitefileformats");
    //Constructor for initialise the directory path
    public Folder(File directory) {
        this.directory = directory;
    }

    public void fetchFiles() {
        File[] folder = directory.listFiles();
        for (int i = 0; i < folder.length; i++) {
            files.add(folder[i]);
        }
        System.out.println("Files fetched");
    }

    public String fetchExtension(File file){
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if(lastIndexOf==-1){
            return ""; //empty extension
        }
        return name.substring(lastIndexOf);
    }

    public String fetchCatergory(String extension){
        //Binary search to find the index in database
        BinarySearch Search = new BinarySearch();
        int index = Search.binarySearch(database,extension,0,database.size());
        if (index == -1){
            return "";
        }else{
            //Fetches the categories index
            int caterogy = Integer.parseInt((database.get(index)).split(":")[1]);
            return categories.get(caterogy);
        }
    }

    public void makeFolder(String foldername){
        File file = new File(directory+"\\"+foldername);
        if(!file.exists()){
            if(file.mkdir()){
                System.out.println("Directories are created!");
            }else{
                System.out.println("Directories are not created!");
            }
        }else{
            System.out.println("Directories already exist!");
        }
    }

    public void moveFile(String fileDestination, String destination){
        File a = new File(fileDestination);
        a.renameTo(new File(destination+"\\"+a.getName()));
        a.delete();
    }

    public void printFiles(){
        System.out.println("Printing files...");
        for (int i = 0; i<files.size();i++){
            System.out.print(fetchExtension(files.get(i))); //Get file name "files.get(i).getName()"
        }
    }
}