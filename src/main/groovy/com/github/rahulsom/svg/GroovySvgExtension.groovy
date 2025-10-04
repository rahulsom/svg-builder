package com.github.rahulsom.svg

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

import java.util.function.Consumer

@CompileStatic
@TypeChecked
class GroovySvgExtension {
    static <T extends SVGSvgContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGDefsContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGAnimateColorContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGAnimateContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGAnimateMotionContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGAnimateTransformContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGCircleContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGClipPathContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGColorProfileContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGCursorContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGEllipseContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGFilterContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGFontContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGFontFaceContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGGContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGGlyphContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGImageContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGLineContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGLinearGradientContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGMarkerContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGMaskContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGMissingGlyphContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGMpathContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGPathContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGPatternContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGPolygonContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGPolylineContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGRadialGradientContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGRectContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGSetContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGSwitchContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGSymbolContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.things)
        return self
    }

    static <T extends SVGTrefContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withAnimateOrSetOrAnimateColor(context.things)
        return self
    }

    static <T extends SVGUseContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

    static <T extends SVGViewContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext()
        consumer.accept(context)
        self.withSVGDescriptionClass(context.things)
        return self
    }

}
