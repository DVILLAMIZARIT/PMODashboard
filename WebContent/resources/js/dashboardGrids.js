/**
 * 
 */
var mygrid;

function doInitGrid(data){
	
	alert("Datos " + data);
	
	mygrid = new dhtmlXGridObject('mygrid_container');
	mygrid.setImagePath("resources/images/");
	mygrid.setHeader("Summary,Projects,Initiatives");
	mygrid.setInitWidths("*,150,150");
	mygrid.setColAlign("left,right,right");
	mygrid.setSkin("light");
	mygrid.init();
	//mygrid.loadXML("resources/Data/tableProject.xml");
	mygrid.parse(data, "json");
}