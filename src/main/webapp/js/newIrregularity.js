document.addEventListener("DOMContentLoaded", function () {
    let nipField = document.querySelector("#nip");
    let findNip = document.querySelector("#findNip");
    let saveButton = document.getElementById("saveIrregularity");
    findNip.style.visibility = "hidden";
    function isValidNip() {
        let nip = nipField.value;
        if(typeof nip !== 'string')
            return false;
        nip = nip.replace(/[\ \-]/gi, '');
        let weight = [6, 5, 7, 2, 3, 4, 5, 6, 7];
        let sum = 0;
        let controlNumber = parseInt(nip.substring(9, 10));
        for (let i = 0; i < weight.length; i++) {
            sum += (parseInt(nip.substring(i, i + 1)) * weight[i]);
        }
        return sum % 11 === controlNumber;
    }

    function getProjects(){
        $.get("/rest/project/"+dropdown.value, function (data1, status) {
            projectDropDown.innerHTML="";
            for(var i = 0 ; i < data1.length; i++){
                var option = document.createElement('option');
                option.innerText = data1[i].projectNumber;
                option.value = data1[i].id;
                projectDropDown.append(option);
            }
        })
    }

    let dropdown = document.getElementById("pr-id");
    let projectDropDown = document.getElementById("projectSelect");
    findNip.addEventListener("click", function () {
        $.get("/rest/beneficiary/"+nipField.value, function(data, status){
            dropdown.innerHTML="";
            for(var i = 0 ; i < data.length; i++){
                var option = document.createElement('option');
                option.innerText = data[i].name;
                option.value = data[i].id;
                dropdown.append(option);
            }
            getProjects();
        });
    });
    function showButton(){
        if (isValidNip()){
            findNip.style.visibility = "";
        } else {
            findNip.style.visibility = "hidden";
        }
    }
    nipField.addEventListener("change", showButton);
    nipField.addEventListener("keyup", showButton);
    nipField.addEventListener("keydown", showButton);

    dropdown.addEventListener("change", function () {
        console.log(dropdown.value);
        getProjects();
    });

    let irregularityTypes = document.getElementById("irregularityType");

    saveButton.addEventListener("click", function () {
        let itList = [];
        $("#irregularityType :selected").each(function(){
            itList.push($(this).val());
        });
        let irregularityDto = {
            created: null,
            creatorId: null,
            dateOfIrregularity: document.getElementById("dateOfIrregularity").value,
            documentBaseIrregularityId: document.getElementById("documentBaseIrregularity").value,
            description: document.getElementById("description").value,
            controlReferenceNumber: document.getElementById("controlReferenceNumber").value,
            contractReferenceNumber: document.getElementById("contractReferenceNumber").value,
            visibleToCA: false,
            actual: true,
            totalExpenses: document.getElementById("totalExpenses").value,
            qualifiedExpenses: document.getElementById("qualifiedExpenses").value,
            reportedInIMS: false,
            detectedBeforeSendToEC: false,
            closedByIB: false,
            closedByMA: false,
            notes: document.getElementById("notes").value,
            CAHasEnded: false,
            caseID: null,
            contractingInstitutionNIP: null,
            beneficiaryId: document.getElementById("pr-id").value,
            irregularityTypes: null,
            projectId: document.getElementById("projectSelect").value
        };
        $.ajax({
            type: "POST",
            url: "/rest/new_irregularity",
            data: JSON.stringify(irregularityDto),
            dataType: "application/json"
        });
    })

});