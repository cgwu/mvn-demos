/*	
 *	jQuery windowResizeFix
 *	
 *	Copyright (c) 2012 Fred Heusschen
 *	www.frebsite.nl
 *
 *	Dual licensed under the MIT and GPL licenses.
 *	http://en.wikipedia.org/wiki/MIT_License
 *	http://en.wikipedia.org/wiki/GNU_General_Public_License
 */


(function( $ )
{

	if ( document.windowResizeFixFired )
	{
		return;
	}
	document.windowResizeFixFired = true;

	var $window = $(window),
		_wWidth = $window.width(),
		_wHeight = $window.height();

	$window.bind(
		'resize',
		function( e )
		{
			var _nWidth = $window.width(),
				_nHeight= $window.height();

			if ( _wWidth == _nWidth && _wHeight == _nHeight )
			{
				e.preventDefault();
				e.stopImmediatePropagation();
				return;
			}
			_wWidth = _nWidth;
			_wHeight = _nHeight;
		}
	);

})( jQuery );