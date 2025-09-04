package com.github.rahulsom.svg

import groovy.transform.CompileStatic

import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Marshaller

@CompileStatic
@NewifySvg
class GroovyBuilder {

	static String createSvg() {
		def svg =
				Svg(height: '3', width: '7').content {
					it << Circle()
					it << SVGHyperlinkClass()
				}

		StringWriter writer = new StringWriter()
		Marshaller marshaller = JAXBContext.newInstance(Svg).createMarshaller()
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE)
		marshaller.marshal(svg, writer)
		writer.toString()
	}

	static String createWithStyle() {
		def svg = Svg(height: "40",
				width: "60").
				content {

					it << SVGStyleClass(content: '.foo {}')

					it << Rect(x: '0', y: '0',
							height: "40",
							width: "60",
							clazz: 'background')

					it << Defs().content {
						it << SVGMarkerClass(id: 'triangle', viewBox: '0 0 10 10',
								refX: '0', refY: '5', markerWidth: '10', markerHeight: '10',
								orient: 'auto', markerUnits: 'userSpaceOnUse')
					}
				}

		StringWriter writer = new StringWriter()
		Marshaller marshaller = JAXBContext.newInstance(Svg).createMarshaller()
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE)
		marshaller.marshal(svg, writer)
		writer.toString()
	}
}
