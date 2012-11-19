#version 120
					
					
attribute vec4 vPosition;
attribute vec4 vColor;
attribute vec2 vTexCoord;
attribute vec4 skyColor;
attribute mat3 lightBlock;
attribute mat3 skyBlock;

varying vec4 color;
varying vec2 uvcoord;

uniform mat4 Projection;
uniform mat4 View;
uniform mat4 Model;
		
void main()
{
	gl_Position = Projection * View  * Model * vPosition;
	
	uvcoord = vTexCoord;
	color = vColor;

} 