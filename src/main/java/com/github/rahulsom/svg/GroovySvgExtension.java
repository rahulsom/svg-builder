package com.github.rahulsom.svg;

import java.util.function.Consumer;

public class GroovySvgExtension {
    private GroovySvgExtension() {
        // This should not be initialized
    }

    public static <T extends SVGSvgContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGDefsContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGAnimateColorContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGAnimateContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGAnimateMotionContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGAnimateTransformContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGCircleContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGClipPathContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGColorProfileContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGCursorContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGEllipseContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGFilterContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGFontContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGFontFaceContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGGContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGGlyphContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGImageContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGLineContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGLinearGradientContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGMarkerContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGMaskContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGMissingGlyphContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGMpathContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGPathContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGPatternContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGPolygonContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGPolylineContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGRadialGradientContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGRectContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGSetContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGSwitchContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGSymbolContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClassOrSVGAnimationClassOrSVGStructureClass(context.getThings());
        return self;
    }

    public static <T extends SVGTrefContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withAnimateOrSetOrAnimateColor(context.getThings());
        return self;
    }

    public static <T extends SVGUseContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

    public static <T extends SVGViewContent> T content(T self, Consumer<GroovyContext> consumer) {
        GroovyContext context = new GroovyContext();
        consumer.accept(context);
        self.withSVGDescriptionClass(context.getThings());
        return self;
    }

}
