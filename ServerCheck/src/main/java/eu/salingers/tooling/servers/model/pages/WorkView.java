package eu.salingers.tooling.servers.model.pages;

import java.util.Collections;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlArea;

public interface WorkView {
  List<HtmlDivision> workDivs = Collections.emptyList();
  
  List<HtmlArea> area = Collections.emptyList(); 
  
  default WorkView createView(){
    //create View object
    return this;
  }
  
  
  
}
