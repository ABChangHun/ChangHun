package com.min.proj.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.CreateFolderErrorException;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.team.GroupsGetInfoError;

@Controller
public class DropboxCtrl {

	private static final String ACCESS_TOKEN = "sl.BJqJ2fZnvn3JsuovPwp0fJAnBIcaYxCzjEE47rESox8Diywf4k2OoRakK8gUbilIEJSxTc4KiV1NnxCNiZsam2kuLKCpMiQ8N4kD-O7SK-2uS_Wu8_3v6MlAilvfsyLqi73VbTXMu8dF";		
	private static final  DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
	private static final DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

	private Logger logger = LoggerFactory.getLogger(DropboxCtrl.class);
	
	@RequestMapping(value = "/drop.do",method = RequestMethod.GET)
	public String moveDrop() {
		logger.info("DropboxCtrl DropMatch {}");
		
		return "/proj/dropbox";
	}
	
	@RequestMapping(value = "/dropMatch.do",method = RequestMethod.GET)
	public String DropMatch(HttpSession session) throws CreateFolderErrorException, DbxException {
		logger.info("DropboxCtrl DropMatch {}");
		
//		Metadata.met
		
		int cnt = 0;
		ListFolderResult result = client.files().listFolder("");
		while (true) {
			for (Metadata metadata : result.getEntries()) {
				//TODO 9. ?????????
//                if(metadata.getPathLower().equals("/?????????")) {
				if (metadata.getPathLower().equals("/"+session.getAttribute("projName"))) {
					cnt++;
					break;
				}
			}
			if (!result.getHasMore()) {
				break;
			}
			result = client.files().listFolderContinue(result.getCursor());
		}
//		System.out.println("@@@@@@@@@@        cnt : " + cnt);
		
		if(cnt==0) {
			// TODO 7. ?????????
//			client.files().createFolder("/"+session.getAttribute("projName"));
			client.files().createFolder("/"+session.getAttribute("projName")+"/??????1");
			client.files().createFolder("/"+session.getAttribute("projName")+"/??????2");
			client.files().createFolder("/"+session.getAttribute("projName")+"/??????3");
			client.files().createFolder("/"+session.getAttribute("projName")+"/??????4");
			client.files().createFolder("/"+session.getAttribute("projName")+"/??????5");
		}
		
		return "/proj/dropbox";
	}
	
	@RequestMapping(value = "/dropBaseDown.do",method = RequestMethod.GET)
	public String dropBaseDown() throws DownloadErrorException, DbxException, IOException {
		logger.info("DropboxCtrl dropBaseDown {}");
		//????????? ?????? ?????? ??????
    	String path = "C:\\PROJECTFILE";
    	java.io.File Dropbox = new java.io.File(path);
    	java.io.File DropboxUpload = new java.io.File(path+"\\Upload");
    	
    	if(!Dropbox.exists()) {
    		Dropbox.mkdir();
    	}
    	if(!DropboxUpload.exists()) {
    		DropboxUpload.mkdir();
    	}
        try {
        	for (int i = 1; i < 6; i++) {
        		DbxDownloader<FileMetadata> downloader = client.files().download("/File"+i+".txt");
        		FileOutputStream out = new FileOutputStream("C:\\PROJECTFILE\\File"+i+".txt");
        		downloader.download(out);
        		out.close();
			}
        } catch (DbxException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("???????????? ??????");
		
		return "/proj/dropbox";
	}
	
	@RequestMapping(value = "/dropUpload.do",method = RequestMethod.GET)
	public String dropUpload() throws FileNotFoundException, IOException, UploadErrorException, DbxException {
		logger.info("DropboxCtrl dropUpload {}");
		
	// Upload "test.txt" to Dropbox
    // ?????? ???????????? ????????? ?????? ????????? ?????? ???????????? ?????????????????? ??????????????? ????????? ???????????? ??????.
     
		try (InputStream in = new FileInputStream("C:\\PROJECTFILE\\Upload\\*.txt")) {
     // ?????? ??????????????? ?????? ???????????? ???????????? ???????????????
     	FileMetadata metadata = client.files().uploadBuilder("/testYam.txt")
             .uploadAndFinish(in);
     }
		System.out.println("?????????");
		return "/proj/dropbox";
	}
}
