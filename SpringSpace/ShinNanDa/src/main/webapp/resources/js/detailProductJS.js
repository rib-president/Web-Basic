/**
 * 
 */


	document.addEventListener('keydown', function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		  };
		}, true);	


	var old_count = 0;
	var layerpop = null;
	
	window.addEventListener("DOMContentLoaded" , function(){
		layerpop = new bootstrap.Modal(document.getElementById('layerpop'));
	});
	

	function optionOnChange(selectBox) {
		
		  if(selectBox.value == "invalidOption") return;
		
		  var idx = selectBox.selectedIndex;

		  var value = selectBox[idx].innerText;
		  
		  var selectedProductBox = document.getElementById("selectedProductBox");
		  
		  var optionList = selectedProductBox.getElementsByClassName("option");
		  
		  for(option of optionList) {
			  if(option.innerText == value) {
				  return;
			  }
		  }
		  
		  var row = document.createElement("div");
		  row.setAttribute("class", "row mb-3");
		  
		  var col1 = document.createElement("div");
		  col1.setAttribute("class", "col option");
		  col1.innerText = value;
		  
		  var col2 = document.createElement("div");
		  col2.setAttribute("class", "col");
		  
		  var hidden_no = selectBox.value.split("&stock")[0];
		  var hidden_stock = selectBox.value.split("&stock")[1];

		  var submitOptions = document.createElement("input");
		  submitOptions.setAttribute("type", "hidden");
		  submitOptions.setAttribute("name", "product_detail_no");
		  submitOptions.setAttribute("value", hidden_no);

		  var submitDiv = document.createElement("div");
		  submitDiv.setAttribute("style", "display: none;");
		  submitDiv.setAttribute("class", "stock");
		  submitDiv.innerText = hidden_stock;
		  
		  var inputNumber = document.createElement("input");
		  inputNumber.setAttribute("type", "number");
		  inputNumber.setAttribute("name", "productCount");
		  inputNumber.setAttribute("min", "1");
		  inputNumber.setAttribute("max", "999");
		  inputNumber.setAttribute("value", "1");
		  inputNumber.setAttribute("class", "count")
		  inputNumber.setAttribute("onchange", "countOnChange(this)");
		  
		  var delBtn = document.createElement("button");
		  delBtn.innerText = "X";
		  delBtn.setAttribute("class", "ms-2 delBtn");
		  delBtn.setAttribute("onclick", "deleteOption(this)");
		  
		  col2.appendChild(submitOptions);
		  col2.appendChild(submitDiv);
		  col2.appendChild(inputNumber);
		  col2.appendChild(delBtn);
		
		  old_count++;
		  
		  document.getElementById("totalPrice").innerText = product_price * old_count;
		  document.getElementById("totalCount").innerText = "(" + old_count + "개)";		  
		  
		  
		  
		  row.appendChild(col1);
		  row.appendChild(col2);
		  selectedProductBox.appendChild(row);		  
	}
	
	function countOnChange(cnt) {
		var col = cnt.closest(".col");
		var stock = col.querySelector(".stock").innerText;
		
		if(parseInt(cnt.value) > parseInt(stock)) {
			alert("재고가 부족합니다. 현재  " + stock + "개");
			cnt.value = stock;
		}
		
		changeTotal();
	}
	
	function changeTotal() {
		var countList = document.getElementsByClassName("count");
		var totalCount = 0;
		for(count of countList) {
			totalCount += count.value*1;
		}
		old_count = totalCount;
		
		document.getElementById("totalPrice").innerText = product_price  * totalCount + "원";
		document.getElementById("totalCount").innerText = "(" + totalCount + "개)";		
	}
	
	function deleteOption(delBtn) {
		var target = delBtn.closest(".row");
		target.remove();
		changeTotal();
	}
	
	function buynow(btn) {
		var optionBox = document.querySelector("#optionBox");
		
		if(optionBox.querySelector("input[name='product_detail_no']") == null) {
			alert("상품 옵션을 선택해주세요");
			return;
		}
		
		var buyNowFrm = document.querySelector("#buyNowFrm");
		
		var options = optionBox.querySelectorAll("input[name='product_detail_no']");
		for(option of options) {
			  var submitOptions = document.createElement("input");
			  submitOptions.setAttribute("type", "hidden");
			  submitOptions.setAttribute("name", "product_detail_no");
			  submitOptions.setAttribute("value", option.value);
			  
			  buyNowFrm.appendChild(submitOptions);
		}		

		var counts = optionBox.querySelectorAll("input[name='productCount']");
		for(count of counts) {
			  var inputNumber = document.createElement("input");
			  inputNumber.setAttribute("type", "hidden");
			  inputNumber.setAttribute("name", "productCount");
			  inputNumber.setAttribute("value", count.value);
			  
			  buyNowFrm.appendChild(count);
		}

		buyNowFrm.submit();
		
		var children = buyNowFrm.querySelectorAll("input");
		for(child of children) {
			buyNowFrm.removeChild(child);
		}
	}
	
	function addCart(btn) {
		var optionBox = document.querySelector("#optionBox");
		
		if(optionBox.querySelector("input[name='product_detail_no']") == null) {
			alert("상품 옵션을 선택해주세요");
			return;
		}		
		
		var options = optionBox.querySelectorAll("input[name='product_detail_no']");
		var options_list = [];
		for(option of options) {
			options_list.push(option.value);
		}
		
		var counts = optionBox.querySelectorAll("input[name='productCount']");
		var counts_list = [];
		for(count of counts) {
			counts_list.push(count.value);
		}
		
		var data = {
			product_detail_no : options_list,	
			productCount : counts_list
		}; 

		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = JSON.parse(xhr.responseText);
				
				if(data.result == 'success') {
					//layerpop = new bootstrap.Modal(document.getElementById('layerpop'));
					layerpop.show();
				}
			}
			
		};
		
		console.log(data);
		xhr.open("POST" , "./addCartProcess", true);	// GET일 때는 링크 뒤에 파라미터 붙임
   		xhr.setRequestHeader("Content-type","application/json"); //Post
		xhr.send(JSON.stringify(data));	// POST일 때는 send에 파라미터 넣음 xhr.send("board_no=6&member_no=1");

	}
	
	function closeModal() {
	    //$("#layerpop").modal("hide");
	    layerpop.hide();
	    closeDetailProductModal();

	}