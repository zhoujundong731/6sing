// JavaScript Document
function gd(ID1,ID2,ID3,ID4){
		document.getElementById(ID1).style.display="block";
		document.getElementById(ID2).style.display="none";
		document.getElementById(ID3).style.backgroundColor="#61697c";
		document.getElementById(ID4).style.backgroundColor="#FFFFFF";
	   }

//歌单专辑变换图片



var curIndex=0;
//时间间隔(单位毫秒)，每秒钟显示一张，数组共有8张图片放在Photos文件夹下。
var timeInterval=4000;
var arr=new Array();
arr[0]="images/tu1.jpg";
arr[1]="images/tu2.jpg";
arr[2]="images/tu3.jpg";
arr[3]="images/tu4.jpg";
arr[4]="images/tu5.jpg";
setInterval(changeImg,timeInterval);
function changeImg(){ 

                      var obj=document.getElementById("tu");    
                           if (curIndex==arr.length-1)    
						   {        
						   curIndex=0; 
						   }    
                            else    { 
							curIndex+=1;   
							}    
							obj.src=arr[curIndex];}
							
//图像变换	
//上部搜索
function Stype(ST1){
		var ss=document.getElementById(ST1).innerHTML;
		document.getElementById("top_stype").value=ss;
		}
//切换
function changeSong(id){
	for(var i=0;i<3;i++){
		document.getElementById("min"+i).style.display="none";
		document.getElementById("top"+i).style.backgroundColor="#FFF";
		}
		document.getElementById("min"+id).style.display="block";
		document.getElementById("top"+id).style.backgroundColor="#61697c";
	}
	function changeFen(id){
	for(var i=0;i<2;i++){
		document.getElementById("fman"+i).style.display="none";
		document.getElementById("fen"+i).style.backgroundColor="#FFF";
		}
		document.getElementById("fman"+id).style.display="block";
		document.getElementById("fen"+id).style.backgroundColor="#61697c";
	}