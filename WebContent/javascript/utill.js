  function showHide() {
		if (document.getElementById('entryLevelCb').checked) {
			document.getElementById('entryLevel').style.visibility = 'visible';
			document.getElementById('po').style.visibility = 'visible';
			document.getElementById('ad').style.visibility = 'visible';
			document.getElementById('ds').style.visibility = 'visible';

		} else {
			document.getElementById('entryLevel').style.visibility = 'hidden';
			document.getElementById('po').style.visibility = 'hidden';
			document.getElementById('ad').style.visibility = 'hidden';
			document.getElementById('ds').style.visibility = 'hidden';

		}
	}

	function showManger() {
		if (document.getElementById('testManger').checked) {
			document.getElementById('tmentryLevel').style.visibility = 'visible';
			document.getElementById('tmpo').style.visibility = 'visible';
			document.getElementById('tmad').style.visibility = 'visible';
			document.getElementById('tmds').style.visibility = 'visible';

		} else {
			document.getElementById('tmentryLevel').style.visibility = 'hidden';
			document.getElementById('tmpo').style.visibility = 'hidden';
			document.getElementById('tmad').style.visibility = 'hidden';
			document.getElementById('tmds').style.visibility = 'hidden';
		}
	}
	  function mshowHide() {
			if (document.getElementById('mentryLevelCb').checked) {
				document.getElementById('mentryLevel').style.visibility = 'visible';
				document.getElementById('mpo').style.visibility = 'visible';
				document.getElementById('mad').style.visibility = 'visible';
				document.getElementById('mds').style.visibility = 'visible';

			} else {
				document.getElementById('mentryLevel').style.visibility = 'hidden';
				document.getElementById('mpo').style.visibility = 'hidden';
				document.getElementById('mad').style.visibility = 'hidden';
				document.getElementById('mds').style.visibility = 'hidden';

			}
		}

		function mshowManger() {
			if (document.getElementById('mtestManger').checked) {
				document.getElementById('mtmentryLevel').style.visibility = 'visible';
				document.getElementById('mtmpo').style.visibility = 'visible';
				document.getElementById('mtmad').style.visibility = 'visible';
				document.getElementById('mtmds').style.visibility = 'visible';

			} else {
				document.getElementById('mtmentryLevel').style.visibility = 'hidden';
				document.getElementById('mtmpo').style.visibility = 'hidden';
				document.getElementById('mtmad').style.visibility = 'hidden';
				document.getElementById('mtmds').style.visibility = 'hidden';
			}
		}
