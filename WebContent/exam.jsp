<html>
<head>
<script type="text/javascript">

	//첨부파일 추가
    var rowIndex = 1;
               
    function addFile(form){
        if(rowIndex > 2) return false;

        rowIndex++;
        var getTable = document.getElementById("insertTable");
	var oCurrentRow = getTable.insertRow(getTable.rows.length);
        var oCurrentCell = oCurrentRow.insertCell(0);
        oCurrentCell.innerHTML = "<tr><td colspan=2><INPUT TYPE='FILE' NAME='filename" + rowIndex + "' size=25></td></tr>";
    }
   
	//첨부파일 삭제
    function deleteFile(form){
        if(rowIndex<2){
            return false;
        }else{
        	rowIndex--;
			var getTable = document.getElementById("insertTable");
			getTable.deleteRow(rowIndex);
       }
    }
    
</script>
</head>

<body>
<form name="write">
     <table id='insertTable' border=0 cellpadding=0 cellspacing=0>
        <tr>
        	<td valign=bottom>
        		<INPUT type='file' maxLength='100' name='filename1' size='25'>
        	</td>
        	<td width=100>
        		<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
        		<input type="button" value="삭제" onClick='deleteFile(this.form)' border=0 style='cursor:hand'>
        	</td>
        </tr>
    </table>
    <input type="hidden" name="rowCount" value="1">
    <input type="submit">
</form>                       
</body>
</html>
